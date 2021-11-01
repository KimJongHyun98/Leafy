package com.plant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.plant.dto.ComparisonDTO;
import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBoardDTO;
import com.plant.dto.MemberDTO;
import com.plant.dto.NoticeDTO;
import com.plant.dto.PCBoardDTO;
import com.plant.dto.PaggingVO;
import com.plant.dto.ReviewDTO;
import com.plant.dto.TBoardDTO;
import com.plant.service.FBoardService;
import com.plant.service.LoginService;
import com.plant.service.NoticeService;
import com.plant.service.PCBoardService;
import com.plant.service.TBoardService;

@Controller
public class MainController { // 메인컨트롤러
	private MemberService memberService;
	private FBoardService fBoardService;
	private PBoardService pBoardService;
	private TBoardService tBoardService;
	private PCBoardService pcBoardService;
	private NoticeService noticeService;

	public MainController(MemberService memberService,FBoardService fBoardService,PBoardService pBoardService,TBoardService tBoardService,PCBoardService pcBoardService,NoticeService noticeService) {
		super();
		this.memberService = memberService;
		this.fBoardService = fBoardService;
		this.pBoardService = pBoardService;
		this.tBoardService = tBoardService;
		this.pcBoardService = pcBoardService;
		this.noticeService = noticeService;
	}

	// 오형석 기능 부분(자유게시판 / 포토게시판)
	// 페이지 이동 10/20
	@RequestMapping("/") 
	public String index() {
		return "index";
	}
	
	// 로그인 페이지 임시처리 10/25
	@RequestMapping("login.do")
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String id = request.getParameter("id"); 
		String passwd = request.getParameter("passwd");
		
		MemberDTO mdto = memberService.login(id,passwd);
		
		if(mdto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디 비밀번호 확인하세요');history.back();</script>");
			return null;
		}else {
			request.getSession().setAttribute("client", mdto);
			return photoBoardList(request, request.getSession());
		}
	}
	
	// 자유게시판 페이지 전체 출력 및 페이징 처리 10/20
	@RequestMapping("freeBoardList.do")
	public String freeBoardList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);
				
		ArrayList<FBoardDTO> fbList = fBoardService.selectAllFBoard(currentPageNo);
		request.setAttribute("fbList", fbList);
		
		// 페이징 처리
		int count = fBoardService.selectFBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
		request.setAttribute("pagging", vo);
		
		return "board/fb/freeboard_list";
	}
	
	// 포토게시판 페이지 전체 출력 및 페이징 처리 10/31
	@RequestMapping("photoBoardList.do")
	public String photoBoardList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1: Integer.parseInt(pageNo);

		// 조회수 높은 게시판 슬라이더 처리
		ArrayList<PBoardDTO> mvpbList = pBoardService.selectMVPBoard();
		request.setAttribute("mvpbList", mvpbList);
		
		// 전체 게시판 페이징 처리 후 출력
		ArrayList<PBoardDTO> pbList = pBoardService.selectAllPBoard(currentPageNo);
		request.setAttribute("pbList", pbList);
		
//		// 썸네일 이미지 처리
//		int pb_fno = Integer.parseInt(request.getParameter("pb_fno"));
//		PBFileDTO pbfdto = pBoardService.selectPBThumbnail(pb_fno);
//		request.setAttribute("thumbnail", pbfdto);
		
		// 페이징 처리
		int count = pBoardService.selectPBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 12, 5);
		request.setAttribute("pagging", vo);
		
		return "board/pb/photoboard_list"; 
	}
	
	// 자유게시판 검색 및 페이징 처리 10/21
	@RequestMapping("freeBoardSearch.do")
	public String freeBoardSearch(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		String kind = request.getParameter("kind");
		System.out.println(kind);
		String search = request.getParameter("search");
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<FBoardDTO> fbList = fBoardService.selectFBoard(kind, search, currentPageNo);
		request.setAttribute("fbList", fbList);
		System.out.println(fbList.toString());

		// 페이징 처리(검색결과 개수)
		int count = fBoardService.selectFBoardSearchCount(kind, search);
		PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
		request.setAttribute("kind", kind);
		request.setAttribute("search", search);
		request.setAttribute("count", count);
		request.setAttribute("pagging", vo);
		
		return "board/fb/freeboard_list";
	}

	// 포토게시판 검색 및 페이징 처리 10/29
	@RequestMapping("photoBoardSearch.do")
	public String photoBoardSearch(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<PBoardDTO> pbList = pBoardService.selectPBoard(kind, search, currentPageNo);
		request.setAttribute("pbList", pbList);

		// 페이징 처리(검색결과 개수)
		int count = pBoardService.selectPBoardSearchCount(kind, search);
		PaggingVO vo = new PaggingVO(count, currentPageNo, 12, 5);
		request.setAttribute("kind", kind);
		request.setAttribute("search", search);
		request.setAttribute("count", count);
		request.setAttribute("pagging", vo);
		
		return "board/pb/photoboard_list";
	}

	// 자유게시판 상세 게시글 10/25
	@RequestMapping("freeBoardView.do")
	public String freeBoardView(HttpServletRequest request, HttpSession session) {
		// 상세 게시글 출력
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.addFBoardCount(fb_no);
		FBoardDTO dto = fBoardService.selectFBoardContent(fb_no);
		request.setAttribute("fBoard", dto);
		
		// 파일 목록
		ArrayList<FBFileDTO> flist = fBoardService.selectFileList(fb_no);
		request.setAttribute("flist", flist);

		// 댓글 쓰는 창
		String id = ((MemberDTO)session.getAttribute("client")).getId();
		request.setAttribute("id", id);

		// 댓글 출력창
		List<FBCommentDTO> fbclist = fBoardService.selectFBoardComment(fb_no);
		request.setAttribute("fbclist", fbclist);
		
		return "board/fb/freeboard_view";
	}
	
	// 포토게시판 상세 게시글 10/29
	@RequestMapping("photoBoardView.do")
	public String photoBoardView(HttpServletRequest request, HttpSession session) {
		// 상세 게시글 출력
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.addPBoardCount(pb_no);
		PBoardDTO dto = pBoardService.selectPBoardContent(pb_no);
		request.setAttribute("pBoard", dto);
		
		// 파일 목록
		ArrayList<PBFileDTO> flist = pBoardService.selectFileList(pb_no);
		request.setAttribute("flist", flist);

		// 댓글 쓰는 창
		String id = ((MemberDTO)session.getAttribute("client")).getId();
		request.setAttribute("id", id);

		// 댓글 출력창
		ArrayList<PBCommentDTO> pbclist = pBoardService.selectPBoardComment(pb_no);
		request.setAttribute("pbclist", pbclist);
		
		return "board/pb/photoboard_view";
	}

	// 자유게시판 상세 게시글 파일 다운로드 10/25
	@RequestMapping("freeBoardFileDownload.do")
	public String freeBoardFileDownload(HttpServletRequest request, HttpServletResponse response) {
		int fb_fno = Integer.parseInt(request.getParameter("fb_fno"));
		
		FBFileDTO fbfdto = fBoardService.selectFile(fb_fno);
		
		File file = new File(fbfdto.getPath());
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			String encodingName = URLEncoder.encode(file.getAbsolutePath(),"utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="+fbfdto.getOriginalFileName());
			response.setHeader("Content-Transfer-Encode", "binary");
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[1024*1024];
			while(true) {
				int count = fis.read(buffer);
				if(count == -1) break;
				bos.write(buffer,0,count);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)
					fis.close();
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 포토게시판 상세 게시글 파일 다운로드 및 화면 출력 10/29
	@RequestMapping("photoBoardFileDownload.do")
	public String photoBoardFileDownload(HttpServletRequest request, HttpServletResponse response) {
		int pb_fno = Integer.parseInt(request.getParameter("pb_fno"));
		
		PBFileDTO pbfdto = pBoardService.selectFile(pb_fno);
		
		File file = new File(pbfdto.getPath());
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			String encodingName = URLEncoder.encode(file.getAbsolutePath(),"utf-8");
			response.setHeader("Content-Disposition", "attachment;filename="+pbfdto.getOriginalFileName());
			response.setHeader("Content-Transfer-Encode", "binary");
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[1024*1024];
			while(true) {
				int count = fis.read(buffer);
				if(count == -1) break;
				bos.write(buffer,0,count);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null)
					fis.close();
				if(bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	// 자유게시판 댓글 입력 10/28
	@RequestMapping("freeBoardInsertComment.do")
	public String freeBoardInsertComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 댓글 입력 요소
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		String id = ((MemberDTO)session.getAttribute("client")).getId();
		String fb_comment_content = request.getParameter("fb_comment_content");
		
		int result = fBoardService.insertFBComment(new FBCommentDTO(fb_no, id, fb_comment_content));
		request.setAttribute("result", result);
		
		return "redirect:freeBoardView.do?fb_no="+fb_no;
	}
	
	// 포토게시판 댓글 입력 10/29
	@RequestMapping("photoBoardInsertComment.do")
	public String photoBoardInsertComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 댓글 입력 요소
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		String commentor_id = ((MemberDTO)session.getAttribute("client")).getId();
		String pb_comment_content = request.getParameter("pb_comment_content");
		
		int result = pBoardService.insertPBComment(new PBCommentDTO(pb_no, commentor_id, pb_comment_content));
		request.setAttribute("result", result);
		
		return "redirect:photoBoardView.do?pb_no="+pb_no;
	}

	// 자유게시판 댓글 삭제 10/28
	@RequestMapping("freeBoardDeleteComment.do")
	public String freeBoardDeleteComment(HttpServletRequest request) {
		int fbc_no = Integer.parseInt(request.getParameter("fbc_no"));
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.deleteFBComment(fbc_no);
		
		return "redirect:freeBoardView.do?fb_no="+fb_no;
	}
	
	// 포토게시판 댓글 삭제 10/29
	@RequestMapping("photoBoardDeleteComment.do")
	public String photoBoardDeleteComment(HttpServletRequest request) {
		int pbc_no = Integer.parseInt(request.getParameter("pbc_no"));
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.deletePBComment(pbc_no);
		
		return "redirect:photoBoardView.do?pb_no="+pb_no;
	}
	
	// 자유게시판 게시글 추천올리는 기능 10/21 미완성
	@RequestMapping("freeBoardRecommand.do")
	public String freeBoardRecommand(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, JSONException {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		String id = ((MemberDTO)session.getAttribute("client")).getId();
		response.setContentType("text/html;charset=utf-8");
		JSONObject obj = new JSONObject();
		if(id == null) {
			obj.put("msg", "로그인하셔야 이용하실수 있습니다.");
			obj.put("code", 400);
			response.getWriter().write(obj.toString());
			return null;
		}
		boolean result = fBoardService.insertFBoardRecommand(fb_no, id);
		String msg = result ? "게시글을 추천하였습니다." : "게시글 추천을 취소하였습니다.";
		obj.put("msg",msg);
		obj.put("code",200);
		response.getWriter().write(obj.toString());

		return null;
	}

	// 포토게시판 게시글 추천올리는 기능 아직 작업안함

	
	// 자유게시판 글쓰기 페이지 이동 10/20
	@RequestMapping("freeBoardWriteView.do")
	public String freeBoardWriteView() {
		return "board/fb/freeboard_write";
	}
	
	// 포토게시판 글쓰기 페이지 이동 10/29
	@RequestMapping("photoBoardWriteView.do")
	public String photoBoardWriteView() {
		return "board/pb/photoboard_write";
	}
	
	// 자유게시판 글쓰기 페이지 10/25
	@RequestMapping("freeBoardWrite.do")
	public String freeBoardWrite(MultipartHttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		String fb_title = request.getParameter("fb_title");
		String fb_content = request.getParameter("fb_content");
		String creator_id = ((MemberDTO)session.getAttribute("client")).getId();
		int fb_no = fBoardService.insertFBoard(new FBoardDTO(creator_id, 0, fb_title, fb_content, null, null, 0, 0));
		// 업로드할 파일 목록
		List<MultipartFile> fileList = request.getFiles("file");
		String path = "c:\\fileupload\\"+creator_id+"\\";
		ArrayList<FBFileDTO> flist = new ArrayList<FBFileDTO>();
		
		int i = 1;
		for(MultipartFile mf : fileList) {
			// 원본 파일명
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if(fileSize == 0) continue;
			//저장할 파일 경로 완성
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			//실제 저장할 파일 경로
			String saveName = format.format(Calendar.getInstance().getTime())+"_"+i+"."+originalFileName.substring(idx+1);
			i++;
			String saveFile = path + saveName;
			File f = new File(saveFile);
			FBFileDTO fbdto = new FBFileDTO(f);
			fbdto.setOriginalFileName(originalFileName);
			fbdto.setFb_no(fb_no);
			flist.add(fbdto);
			
			try {
				File parentPath = new File(path);
				if(!parentPath.exists()) parentPath.mkdirs();
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		fBoardService.insertFileList(flist);
		
		return "redirect:freeBoardList.do";
	}

	// 포토게시판 글쓰기 페이지 10/29
	@RequestMapping("photoBoardWrite.do")
	public String photoBoardWrite(MultipartHttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
		String creator_id = ((MemberDTO)session.getAttribute("client")).getId();
		String pb_title = request.getParameter("pb_title");
		String pb_content = request.getParameter("pb_content");
		int pb_no = pBoardService.insertPBoard(new PBoardDTO(creator_id, 0, pb_title, pb_content, null, null, 0, 0));
		// 업로드할 파일 목록
		List<MultipartFile> fileList = request.getFiles("file");
		String path = "c:\\fileupload\\"+creator_id+"\\";
		ArrayList<PBFileDTO> flist = new ArrayList<PBFileDTO>();
		
		int i = 1;
		for(MultipartFile mf : fileList) {
			// 원본 파일명
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if(fileSize == 0) continue;
			//저장할 파일 경로 완성
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			//실제 저장할 파일 경로
			String saveName = format.format(Calendar.getInstance().getTime())+"_"+i+"."+originalFileName.substring(idx+1);
			i++;
			String saveFile = path + saveName;
			File f = new File(saveFile);
			PBFileDTO pbfdto = new PBFileDTO(f);
			pbfdto.setOriginalFileName(originalFileName);
			pbfdto.setPb_no(pb_no);
			flist.add(pbfdto);
			
			try {
				File parentPath = new File(path);
				if(!parentPath.exists()) parentPath.mkdirs();
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		pBoardService.insertFileList(flist);
		
		return "redirect:photoBoardList.do";
	}
	
	
	// 자유게시글 수정 페이지로 이동 10/26
	@RequestMapping("freeBoardUpdateView.do")
	public String freeBoardUpdateView(HttpServletRequest request) {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		FBoardDTO fbdto = fBoardService.selectFBoardContent(fb_no);
		request.setAttribute("fbdto", fbdto);
		
		return "board/fb/freeboard_update_view";
	}
	
	// 포토게시글 수정 페이지로 이동 10/29
	@RequestMapping("photoBoardUpdateView.do")
	public String photoBoardUpdateView(HttpServletRequest request) {
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		PBoardDTO pbdto = pBoardService.selectPBoardContent(pb_no);
		request.setAttribute("pbdto", pbdto);
		
		return "board/pb/photoboard_update_view";
	}

	// 자유게시글 수정 10/26
	@RequestMapping("freeBoardUpdate.do")
	public String freeBoardUpdate(HttpServletRequest request) {
		String fb_title = request.getParameter("fb_title");
		String fb_content = request.getParameter("fb_content");
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		System.out.println(fb_title);
		System.out.println(fb_content);
		System.out.println(fb_no);
		fBoardService.updateFBoard(fb_no,fb_title,fb_content);

		return "redirect:freeBoardView.do?fb_no="+fb_no;
	}
	
	// 포토게시글 수정 10/29
	@RequestMapping("photoBoardUpdate.do")
	public String photoBoardUpdate(HttpServletRequest request) {
		String pb_title = request.getParameter("pb_title");
		String pb_content = request.getParameter("pb_content");
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.updatePBoard(pb_no, pb_title, pb_content);

		return "redirect:photoBoardView.do?pb_no="+pb_no;
	}
	
	// 자유게시글 삭제 10/28
	@RequestMapping("freeBoardDelete.do")
	public String freeBoardDelete(HttpServletRequest request) {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.deleteFBoard(fb_no);
		return "redirect:freeBoardList.do";
	}
	
	// 포토게시글 삭제 10/29
	@RequestMapping("photoBoardDelete.do")
	public String photoBoardDelete(HttpServletRequest request) {
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.deletePBoard(pb_no);
		return "redirect:photoBoardList.do";
	}
	
	// 안태진님 기능 부분(가격비교 게시판 / 회사소개)
	// 가격정보 서치 페이지 10/20
	@RequestMapping("price_search.do")
	public String search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String search = request.getParameter("search");//페이지input 항목 가져오기
		response.setContentType("text/html;charset=utf-8");
		ArrayList<ComparisonDTO> searchList = new ArrayList<>();
		searchList = searchApi(search);
		System.out.println(searchList);
		request.setAttribute("searchList", searchList);//api이용한 가격정보 request저장
		return "price_comparison";
	}
	
	// 리뷰정보 보기기능 10/20
	@RequestMapping(value = "seeMore.do")
	public String seeMore(HttpServletRequest request, HttpServletResponse response) {
		String link = request.getParameter("link");
		System.out.println(link);
		ArrayList<ReviewDTO> reviewList = new ArrayList<>();
		reviewList = seeMoreReview(link);//크롤링으로 가져온 링크의 리뷰정보 저장
		request.setAttribute("reviewList", reviewList);//리뷰정보리스트 리퀘스트에 저장
		return "price_comparison";
	}

	// 링크정보를 통해 크롤링해서 리뷰정보 가져오는 메서드 - 10/22 resource/driver 폴더에 드라이버 다운로드 후 추가, 경로 재설정 
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "/resource/driver/chromedriver";
	
	private ArrayList<ReviewDTO> seeMoreReview(String link){
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//셀레니움 기본설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);

		String url = link;//hidden input에서 가져온 링크값
		driver.get(url);
		//컴파일속도가 페이지 로딩속도보다 빠르기때문에 타임슬립걸어서 페이지가 로딩이다되면 탐색하게끔 설정
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		//선택자이용하여 내용추출해서 각 리스트에 저장
		List<WebElement> contentList = driver.findElements(By.cssSelector(".YEtwtZFLDz > span"));
		List<WebElement> reviewIdList = driver.findElements(By.cssSelector("._2FmJXrTVEX > strong"));
		List<WebElement> reviewDateList = driver.findElements(By.cssSelector("._2FmJXrTVEX ._3QDEeS6NLn"));
		List<WebElement> reviewSelectList = driver.findElements(By.cssSelector("._3jZQShkMWY > span"));
		List<WebElement> reviewScoreList = driver.findElements(By.cssSelector("._2V6vMO_iLm > em"));
		System.out.println(contentList.size());
		for (Iterator iterator = contentList.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());

		}
		//review 정보를 하나의 dto로변환하여 하나의 리스트로 저장
		ArrayList<ReviewDTO> reviewList = new ArrayList<>();
		for(int i = 0; i < contentList.size(); i++) {
			reviewList.add(new ReviewDTO(reviewScoreList.get(i).getText(), reviewSelectList.get(i).getText(), contentList.get(i).getText(), reviewIdList.get(i).getText(), reviewDateList.get(i).getText()));
		}
		System.out.println("----------");
		System.out.println(reviewList.toString());
		System.out.println("----------");
		System.out.println(contentList.toString());

		driver.close();
		driver.quit();

		return reviewList;
	}
	
	// 네이버 쇼핑 api 10/20
	JSONArray arr;
	private ArrayList<ComparisonDTO> searchApi(String search) {
		String clientId = "_AVjSGJMXRyTaweIE3l0";//애플리케이션 클라이언트 아이디값";
        String clientSecret = "hX5FHl3vY6";//애플리케이션 클라이언트 시크릿값";
        ArrayList<ComparisonDTO> list = new ArrayList<>();
        String msg = null;
        HttpURLConnection con = null;
        BufferedReader br = null;
        String result = "";
        String text = search;
        try {
            text = URLEncoder.encode(text, "UTF-8");

            URL url = new URL("https://openapi.naver.com/v1/search/shop.json?query=" + text + "&display=100");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
            msg = new String();
            while (true) {
                String str = br.readLine();
                if (str == null) break;
                msg += str;
            }
            System.out.println(text + "doInBackground: " + msg);
            JSONObject json = new JSONObject(msg);
            arr = json.getJSONArray("items");
            //api에서 가져올수있는 모든 정보를 list에저장
            for (int i = 0; i < arr.length(); i++) {
                JSONObject temp = (JSONObject) arr.get(i);
                if(temp.getString("category2").equals("원예/식물") && !(temp.getString("category3").equals("조화"))) {
                	list.add(new ComparisonDTO(temp.getString("title"), temp.getString("link"), temp.getString("image"), temp.getString("lprice"), temp.getString("hprice"),
                			temp.getString("mallName"), temp.getInt("productType"), temp.getString("maker"), temp.getString("category1"), temp.getString("category1"),
                			temp.getString("category2"), temp.getString("category3"), temp.getString("category4")));
                	result += temp.getString("title") +
                			" " + temp.getString("link") + " " +
                			temp.getString("lprice") + " " + temp.getString("image") + "\n";
                }
            }
            System.out.println("test" + "doInBackground: " + result);
            System.out.println(result.getClass().getName());
            System.out.println(arr.toString());
            System.out.println(list.toString());

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("인코딩 실패", e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

        }

        return list;
	}
	
	// 김종현님 기능 부분(인덱스-로그인 / 회원가입)
	// 네이버 로그인 페이지 이동 10/22
	@RequestMapping("naver.do")
	public String naverLoginView() {
		return "login/naver_login";
	}
	// 네이버 콜백 페이지 이동 10/22
	@RequestMapping("callback.do")
	public String navercallbackView() {
		return "login/naver_callback";
	}
	// 회원가입 페이지 이동 10/22
	@RequestMapping("register.do")
	public String registerView() {
		return "register/register";
	}
	//Leafy 이용약관 이동 10/22
	@RequestMapping("LeafyMain.do")
	public String leafyMainView() {
		return "register/leafy_main";
	}
	//문자수신 이용약관 이동 10/22
	@RequestMapping("LeafyEvent.do")
	public String leafyEventView() {
		return "register/leafy_event";
	}
	//문자수신 이용약관 이동 10/22
	@RequestMapping("LeafyPrivacy.do")
	public String leafyPrivacyView() {
		return "register/leafy_privacy";
	}
	
	//메인 페이지 이동 10/25
	@RequestMapping("Maingo.do")
	public String MainView() {
		return "main/main";
	}
	// 안세영님 기능 부분(팁 게시판 / 고객센터 - 공지사항,문의)
	
	// TIP 게시판 (썸네일 이미지 보이기 / 좋아요수, 댓글수 ,조회수 처리)
	// TIP 게시판 출력
	@RequestMapping("tipList.do")
	public String tipList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<TBoardDTO> tblist = tBoardService.selectAllTip(currentPageNo);
		request.setAttribute("tblist", tblist);

		// 페이징 처리
		int count = tBoardService.selectTipBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 5);
		request.setAttribute("pagging", vo);

		return "board/tb/tip_list";
	}
	// 팁 게시판 검색
		@RequestMapping("tipBoardSearch.do")
		public String freeBoardSearch(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
			String kind = request.getParameter("kind");
			System.out.println(kind);
			String search = request.getParameter("search");
			String pageNo = request.getParameter("pageNo");
			int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

			List<TBoardDTO> tbList = tBoardService.selectTBoard(kind, search, currentPageNo);
			request.setAttribute("tbList", tbList);
			System.out.println(tbList.toString());

			int count = tBoardService.selectTipBoardSearchCount(kind, search);
			PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
			request.setAttribute("kind", kind);
			request.setAttribute("search", search);
			request.setAttribute("count", count);
			request.setAttribute("pagging", vo);
			
			return "board/tb/tip_list";
		}
		
		// 팁 게시판 상세 페이지
		@RequestMapping("tipBoardView.do")
		public String freeBoardView(HttpServletRequest request, HttpSession session) {
			int tno = Integer.parseInt(request.getParameter("tno"));
			tBoardService.addTipBoardCount(tno);
			TBoardDTO dto = tBoardService.selectTipBoardContent(tno);
			request.setAttribute("tBoard", dto);
			
			List<TBCommentDTO> tclist = tBoardService.selectTipBoardComment(tno);
			request.setAttribute("tclist", tclist);
			System.out.println(tclist);
			
			return "board/tb/tip_view";
		}
		
		// 팁 게시판 추천
		@RequestMapping("tipRecommand.do")
		public String tipRecommand(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
			int tno = Integer.parseInt(request.getParameter("tno"));
			MemberDTO dto = (MemberDTO) request.getSession().getAttribute("client");
			response.setContentType("text/html;charset=utf-8");
			JSONObject obj = new JSONObject();
			if(dto == null) {
				obj.put("msg", "로그인후 이용해주세요.");
				obj.put("code", 400);
				response.getWriter().write(obj.toString());
				return null;
			}
			boolean result = tBoardService.insertTipRecommand(tno, dto.getId());
			String msg = result ? "게시글을 추천했습니다." : "추천을 취소했습니다.";
			obj.put("msg",msg);
			obj.put("code",200);
			response.getWriter().write(obj.toString());

			return null;
		}
		
		// 팁 게시판 댓글 입력
	
//------------------------------------------------------------------------------

	// 21.10.22 세영 (공지사항 게시판 어드민만 글작성 및 수정,삭제가능/댓글x/조회수만처리하기)
	// 공지사항 게시판 출력
	@RequestMapping("NoticeList.do")
	public String noticeList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<NoticeDTO> noticelist = noticeService.selectNotice(1);
		request.setAttribute("noticelist", noticelist);

		int count = noticeService.selectNoticeCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 5);
		request.setAttribute("pagging", vo);
		return "notice_list";
	}

	// 공지사항 글쓰기
	@RequestMapping("noticeWriteView.do")
	public String noticeWriteView() {
		return "notice_write";
	}

	@RequestMapping("noticeWrite.do")
	public String noticeWrite(MultipartHttpServletRequest request, HttpSession session)
			throws UnsupportedEncodingException {

		String title = request.getParameter("notice_title");
		String content = request.getParameter("notice_content");
		String date = request.getParameter("notice_date");
		String url = request.getParameter("notice_url");
		String id = ((NoticeDTO) session.getAttribute("client")).getId();
		int nbno = noticeService.insertNotice(new NoticeDTO(0, id, title, content, url, date, 0));
		// 업로드한 파일 목록
		System.out.println(request.getParameterMap());
		List<MultipartFile> nfileList = request.getFiles("file");
		System.out.println(nfileList.size());
		String path = "c:\\fileupload\\" + id + "\\";
		ArrayList<NoticeFileDTO> nflist = new ArrayList<NoticeFileDTO>();
		int i = 1;
		for (MultipartFile mf : nfileList) {
			// 원본 파일명
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if (fileSize == 0)
				continue;
			// 저장할 파일 경로 완성
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			// 실제 저장할 파일 경로
			String saveName = format.format(Calendar.getInstance().getTime()) + "_" + id + "_" + i + "."
					+ originalFileName.substring(idx + 1);
			i++;
			String saveFile = path + saveName;
			System.out.println(saveFile);
			File f = new File(saveFile);
			NoticeFileDTO dto = new NoticeFileDTO(f);
			dto.setOriginFileName(originalFileName);
			dto.setNbno(nbno);
			dto.setId(id);
			nflist.add(dto);
			System.out.println(dto.toString());
			try {
				// 파일 업로드
				File parentPath = new File(path);
				if (!parentPath.exists())
					parentPath.mkdirs();
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		noticeService.insertFileList(nflist);

		return "redirect:NoticeList.do";

	}

	// 상세 공지 게시글
	@RequestMapping("noticeView.do")
	public String noticeView(HttpServletRequest request, HttpSession session) {
		int nbno = Integer.parseInt(request.getParameter("nbno"));
		noticeService.addNoticeCount(nbno);
		NoticeDTO dto = noticeService.selectNoticeContent(nbno);
		request.setAttribute("notice", dto);

		// 파일목록
		ArrayList<NoticeFileDTO> nflist = noticeService.selectFileList(nbno);
		request.setAttribute("nflist", nflist);

		return "notice_view";
	}

	// 공지 삭제
	@RequestMapping("noticeDelete.do")
	public String noticeDelete(HttpServletRequest request) {
		int nbno = Integer.parseInt(request.getParameter("nbno"));
		noticeService.deleteNotice(nbno);
		return "redirect:NoticeList.do";
	}

	// 공지 수정 페이지로 이동
	@RequestMapping("noticeView.do")
	public String noticeUpdateView(HttpServletRequest request) {
		int nbno = Integer.parseInt(request.getParameter("nbno"));
		NoticeDTO dto = noticeService.selectNoticeContent(nbno);
		request.setAttribute("notice", dto);
		return "notice_update_view";
	}

	// 공지 수정
	@RequestMapping("noticeUpdate.do")
	public String noticeUpdate(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String title = request.getParameter("notice_title");
		String content = request.getParameter("notice_content");
		int nbno = Integer.parseInt(request.getParameter("nbno"));

		noticeService.updateNotice(nbno, title, content);
		redirectAttributes.addAttribute("nbno", nbno);
		return "redirect:/noticeView.do";
	}
	
	

//------------------------------------------------------------------------------

	// 1:1문의 게시판 (어드민만 댓글 달 수 있음 / 어드민 답변 상태 처리 )
	// 1:1문의 게시판 출력
	@RequestMapping("MTMRequsetList.do")
	public String MTMRequestList(HttpServletRequest request) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<MTMRequestDTO> mtmlist = mtmRequestService.selectAllMTM(1);
		request.setAttribute("mtmlist", mtmlist);

		int count = mtmRequestService.selectMTMRequestCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
		request.setAttribute("pagging", vo);
		return "mtm_request_list";
	}

	// 1:1문의 게시판 글쓰기
	@RequestMapping("mtmWriteView.do")
	public String mtmWriteView() {
		return "mtm_request_write";
	}

	@RequestMapping("mtmWrite.do")
	public String mtmWrite(MultipartHttpServletRequest request, HttpSession session)
			throws UnsupportedEncodingException {

		String title = request.getParameter("mtm_request_title");
		String content = request.getParameter("mtm_request_content");
		String date = request.getParameter("mtm_request_date");
		String url = request.getParameter("mtm_request_url");
		String id = ((MTMRequestDTO) session.getAttribute("client")).getId();
		int mno = mtmRequestService.insertMTM(new MTMRequestDTO(id, date, title, content, url, 0, 0));
		// 업로드한 파일 목록
		System.out.println(request.getParameterMap());
		List<MultipartFile> mtmfileList = request.getFiles("file");
		System.out.println(mtmfileList.size());
		String path = "c:\\fileupload\\" + id + "\\";
		ArrayList<MTMFileDTO> mtmflist = new ArrayList<MTMFileDTO>();
		int i = 1;
		for (MultipartFile mf : mtmfileList) {
			// 원본 파일명
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if (fileSize == 0)
				continue;
			// 저장할 파일 경로 완성
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			// 실제 저장할 파일 경로
			String saveName = format.format(Calendar.getInstance().getTime()) + "_" + id + "_" + i + "."
					+ originalFileName.substring(idx + 1);
			i++;
			String saveFile = path + saveName;
			System.out.println(saveFile);
			File f = new File(saveFile);
			MTMFileDTO dto = new MTMFileDTO(f);
			dto.setOriginFileName(originalFileName);
			dto.setMno(mno);
			dto.setId(id);
			mtmflist.add(dto);
			System.out.println(dto.toString());
			try {
				// 파일 업로드
				File parentPath = new File(path);
				if (!parentPath.exists())
					parentPath.mkdirs();
				mf.transferTo(f);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		mtmRequestService.insertFileList(mtmflist);

		return "redirect:MTMRequsetList.do";

	}

	// ckeditor에서 이미지 올리는 url 호출 부분
//	@RequestMapping("imageUpload.do")
//	public String imageUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
//			@RequestParam MultipartFile upload) {
//		OutputStream out = null;
//		PrintWriter printWriter = null;
//		response.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String id = ((MemberDTO) session.getAttribute("client")).getId();
//		try {
//
//			String path = "c:\\fileupload\\" + id;
//			String fileName = upload.getOriginalFilename();
//			byte[] bytes = upload.getBytes();
//			String uploadPath = path + "\\" + fileName;// 저장경로
//			File parentPath = new File(path);
//			if (!parentPath.exists())
//				parentPath.mkdirs();
//			out = new FileOutputStream(new File(uploadPath));
//			out.write(bytes);
//
//			printWriter = response.getWriter();
//
//			// 파일 테이블 등록
//			MTMFileDTO dto = new MTMFileDTO(new File(uploadPath));
//			dto.setId(id);
//			int fno = mtmRequestService.insertFileOne(dto);
//
//			// 이미지 업로드 결과 및 board_write.jsp에 뿌릴 이미지 경로 설정
//			JSONObject json = new JSONObject();
//			json.put("uploaded", 1);
//			json.put("fileName", fileName);
//			json.put("url", "fileDownload.do?fno=" + fno);
//
//			printWriter.println(json.toString());
//			printWriter.flush();
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (out != null) {
//					out.close();
//				}
//				if (printWriter != null) {
//					printWriter.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		return null;
//	}

	// 다운로드
	@RequestMapping("fileDownload.do")
	public String fileDownload(HttpServletRequest request, HttpServletResponse response) {
		int fno = Integer.parseInt(request.getParameter("fno"));

		MTMFileDTO dto = mtmRequestService.selectFile(fno);

		File file = new File(dto.getPath());
		FileInputStream fis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(file);
			String encodingName = URLEncoder.encode(file.getAbsolutePath(), "utf-8");
			response.setHeader("Content-Disposition", "attachment;filename=" + dto.getOriginFileName());
			response.setHeader("Content-Transfer-Encode", "binary");
			bos = new BufferedOutputStream(response.getOutputStream());
			byte[] buffer = new byte[1024 * 1024];
			while (true) {
				int count = fis.read(buffer);
				if (count == -1)
					break;
				bos.write(buffer, 0, count);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fis != null)
					fis.close();
				if (bos != null)
					bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	// 상세 문의 게시글
	@RequestMapping("mtmRequestView.do")
	public String mtmRequestView(HttpServletRequest request, HttpSession session) {
		int mno = Integer.parseInt(request.getParameter("mno"));
		mtmRequestService.addMTMRequestCount(mno);
		MTMRequestDTO dto = mtmRequestService.selectMTMContent(mno);
		request.setAttribute("mtmRequest", dto);

		// 파일목록
		ArrayList<MTMFileDTO> mtmflist = mtmRequestService.selectFileList(mno);
		request.setAttribute("mtmflist", mtmflist);

		return "mtm_request_view";
	}

	// 문의글 삭제
	@RequestMapping("mtmRequestDelete.do")
	public String boardDelete(HttpServletRequest request) {
		int mno = Integer.parseInt(request.getParameter("mno"));
		mtmRequestService.deleteMTMRequest(mno);
		return "redirect:MTMRequsetList.do";
	}

	// 문의글 수정 페이지로 이동
	@RequestMapping("MTMRequestUpdateView.do")
	public String boardUpdateView(HttpServletRequest request) {
		int mno = Integer.parseInt(request.getParameter("mno"));
		MTMRequestDTO dto = mtmRequestService.selectMTMContent(mno);
		request.setAttribute("mtmRequest", dto);
		return "mtm_request_update_view";
	}

	// 문의글 수정
	@RequestMapping("MTMRequestUpdate.do")
	public String boardUpdate(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		String title = request.getParameter("mtm_request_title");
		String content = request.getParameter("mtm_request_content");
		int mno = Integer.parseInt(request.getParameter("mno"));

		mtmRequestService.updateMTMRequest(mno, title, content);
		redirectAttributes.addAttribute("mno", mno);
		return "redirect:/mtmRequestView.do";
	}
	
	// 이희진님 기능 부분(분양 게시판)
	// 분양게시판 출력
	@RequestMapping("ParcelBoardList.do")
	public String ParcelBoardList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("page");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<PCBoardDTO> pcbList = pcBoardService.selectAllPCBoard(currentPageNo);
		request.setAttribute("pcbList", pcbList);

		int count = pcBoardService.selectPCBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
		request.setAttribute("pagging", vo);

		return "board/pcb/parcelboard_list";
	}
	
	private LoginService login;
	
	
	@RequestMapping("Login.do")
	public String login(HttpServletRequest request) {
		List<MemberDTO> list = login.LoginupService();
		request.setAttribute(WEB_DRIVER_ID, list);
		return null;
	}
	
	
	
	
	
	
	
}


