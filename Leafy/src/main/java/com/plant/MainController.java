package com.plant;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

<<<<<<< HEAD
import org.apache.jasper.tagplugins.jstl.core.Out;
import org.openqa.selenium.Alert;
=======
import org.json.JSONArray;
import org.json.JSONObject;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.beust.jcommander.internal.Console;
import com.plant.dto.ComparisonDTO;
import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBoardDTO;
import com.plant.dto.MemberDTO;
<<<<<<< HEAD
import com.plant.dto.NaverDTO;
=======
import com.plant.dto.MessageDTO;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
import com.plant.dto.NoticeDTO;
import com.plant.dto.PBoardDTO;
import com.plant.dto.PCBoardDTO;
import com.plant.dto.PaggingVO;
import com.plant.dto.ReviewDTO;
import com.plant.dto.TBoardDTO;
import com.plant.dto.messageDTO;
import com.plant.service.FBoardService;
import com.plant.service.LoginService;
import com.plant.service.MainService;
//import com.plant.service.MainService;
import com.plant.service.MemberService;
import com.plant.service.NoticeService;
import com.plant.service.PBoardService;
import com.plant.service.PCBoardService;
import com.plant.service.TBoardService;
<<<<<<< HEAD
=======
import com.plant.service.messageService;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a

@Controller
public class MainController { // ??????????????????
	private FBoardService fBoardService;
	private TBoardService tBoardService;
	private NoticeService noticeService;
	private PBoardService pBoardService;
	private PCBoardService pcBoardService;
	private LoginService loginService;



	public MainController(FBoardService fBoardService,TBoardService tBoardService,PCBoardService pcBoardService,NoticeService noticeService, LoginService loginService, PBoardService pBoardService) {
		super();
		this.fBoardService = fBoardService;
		this.tBoardService = tBoardService;
		this.pcBoardService = pcBoardService;
		this.noticeService = noticeService;
		this.loginService = loginService;
		this.pBoardService = pBoardService;
	}
	
	// ????????? ?????? ??????(??????????????? / ???????????????)
	// ????????? ?????? 10/20
	@RequestMapping("/") 
	public String index() {
		return "index";
	}
	
<<<<<<< HEAD
=======
	// ????????? ????????? ???????????? 10/25
//	@RequestMapping("login.do")
//	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		String id = request.getParameter("id"); 
//		String passwd = request.getParameter("passwd");
//		
//		MemberDTO mdto = memberService.login(id,passwd);
//		
//		if(mdto == null) {
//			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().write("<script>alert('????????? ???????????? ???????????????');history.back();</script>");
//			return null;
//		}else {
//			request.getSession().setAttribute("client", mdto);
//			return photoBoardList(request, request.getSession());
//		}
//	}
	
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	// ??????????????? ????????? ?????? ?????? ??? ????????? ?????? 10/20
	@RequestMapping("freeBoardList.do")
	public String freeBoardList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);
				
		ArrayList<FBoardDTO> fbList = fBoardService.selectAllFBoard(currentPageNo);
		request.setAttribute("fbList", fbList);
		
		// ????????? ??????
		int count = fBoardService.selectFBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
		request.setAttribute("pagging", vo);
		
		return "board/fb/freeboard_list";
	}
	
<<<<<<< HEAD
=======
	// ??????????????? ????????? ?????? ?????? ??? ????????? ?????? 10/31
	@RequestMapping("photoBoardList.do")
	public String photoBoardList(HttpServletRequest request, HttpSession session) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1: Integer.parseInt(pageNo);

		// ????????? ?????? ????????? ???????????? ??????
		ArrayList<PBoardDTO> mvpbList = pBoardService.selectMVPBoard();
		request.setAttribute("mvpbList", mvpbList);
		
		// ?????? ????????? ????????? ?????? ??? ??????
		ArrayList<PBoardDTO> pbList = pBoardService.selectAllPBoard(currentPageNo);
		request.setAttribute("pbList", pbList);
		
		// ????????? ??????
		int count = pBoardService.selectPBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 12, 5);
		request.setAttribute("pagging", vo);
		
		return "board/pb/photoboard_list"; 
	}
	
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	// ??????????????? ?????? ??? ????????? ?????? 10/21
	@RequestMapping("freeBoardSearch.do")
	public String freeBoardSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String kind = request.getParameter("kind");
		System.out.println(kind);
		String search = request.getParameter("search");
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<FBoardDTO> fbList = fBoardService.selectFBoard(kind, search, currentPageNo);
		request.setAttribute("fbList", fbList);
		System.out.println(fbList.toString());

		// ????????? ??????(???????????? ??????)
		int count = fBoardService.selectFBoardSearchCount(kind, search);
		PaggingVO vo = new PaggingVO(count, currentPageNo, 10, 5);
		request.setAttribute("kind", kind);
		request.setAttribute("search", search);
		request.setAttribute("count", count);
		request.setAttribute("pagging", vo);
		
		return "board/fb/freeboard_list";
	}
<<<<<<< HEAD
	
	// ??????????????? ?????? ????????? 10/21
=======

	// ??????????????? ?????? ??? ????????? ?????? 10/29
	@RequestMapping("photoBoardSearch.do")
	public String photoBoardSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<PBoardDTO> pbList = pBoardService.selectPBoard(kind, search, currentPageNo);
		request.setAttribute("pbList", pbList);

		// ????????? ??????(???????????? ??????)
		int count = pBoardService.selectPBoardSearchCount(kind, search);
		PaggingVO vo = new PaggingVO(count, currentPageNo, 12, 5);
		request.setAttribute("kind", kind);
		request.setAttribute("search", search);
		request.setAttribute("count", count);
		request.setAttribute("pagging", vo);
		
		return "board/pb/photoboard_list";
	}

	// ??????????????? ?????? ????????? 10/25
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	@RequestMapping("freeBoardView.do")
	public String freeBoardView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("client");
		if(mdto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('????????? ??? ????????? ???????????????.');history.back();</script>");
			return null;
		}
		// ?????? ????????? ??????
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.addFBoardCount(fb_no);
		FBoardDTO dto = fBoardService.selectFBoardContent(fb_no);
		request.setAttribute("fBoard", dto);
		
		// ?????? ?????????
		List<FBCommentDTO> fbclist = fBoardService.selectFBoardComment(fb_no);
		request.setAttribute("fbclist", fbclist);
		System.out.println(fbclist);
		
		return "board/fb/freeboard_view";
	}
	
<<<<<<< HEAD
	// ??????????????? ????????? ??????????????? ?????? 10/21
	@RequestMapping("freeBoardRecommand.do")
	public String freeBoardRecommand(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("client");
		response.setContentType("text/html;charset=utf-8");
		JSONObject obj = new JSONObject();
		if(dto == null) {
=======
	// ??????????????? ?????? ????????? 10/29
	@RequestMapping("photoBoardView.do")
	public String photoBoardView(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("client");
		if(mdto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('????????? ??? ????????? ???????????????.');history.back();</script>");
			return null;
		}
		
		// ?????? ????????? ??????
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.addPBoardCount(pb_no);
		PBoardDTO dto = pBoardService.selectPBoardContent(pb_no);
		request.setAttribute("pBoard", dto);
		
		// ?????? ??????
		ArrayList<PBFileDTO> flist = pBoardService.selectFileList(pb_no);
		request.setAttribute("flist", flist);

		// ?????? ?????? ???
		String id = ((MemberDTO)session.getAttribute("client")).getId();
		request.setAttribute("id", id);

		// ?????? ?????????
		ArrayList<PBCommentDTO> pbclist = pBoardService.selectPBoardComment(pb_no);
		request.setAttribute("pbclist", pbclist);
		
		return "board/pb/photoboard_view";
	}

	// ??????????????? ?????? ????????? ?????? ???????????? 10/25
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

	// ??????????????? ?????? ????????? ?????? ???????????? ??? ?????? ?????? 10/29
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
	
	// ??????????????? ?????? ?????? 10/28
	@RequestMapping("freeBoardInsertComment.do")
	public String freeBoardInsertComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// ?????? ?????? ??????
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		String id = ((MemberDTO)session.getAttribute("client")).getId();
		String fb_comment_content = request.getParameter("fb_comment_content");
		
		int result = fBoardService.insertFBComment(new FBCommentDTO(fb_no, id, fb_comment_content));
		request.setAttribute("result", result);
		
		return "redirect:freeBoardView.do?fb_no="+fb_no;
	}
	
	// ??????????????? ?????? ?????? 10/29
	@RequestMapping("photoBoardInsertComment.do")
	public String photoBoardInsertComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// ?????? ?????? ??????
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		String commentor_id = ((MemberDTO)session.getAttribute("client")).getId();
		String pb_comment_content = request.getParameter("pb_comment_content");
		
		int result = pBoardService.insertPBComment(new PBCommentDTO(pb_no, commentor_id, pb_comment_content));
		request.setAttribute("result", result);
		
		return "redirect:photoBoardView.do?pb_no="+pb_no;
	}

	// ??????????????? ?????? ?????? 10/28
	@RequestMapping("freeBoardDeleteComment.do")
	public String freeBoardDeleteComment(HttpServletRequest request) {
		int fbc_no = Integer.parseInt(request.getParameter("fbc_no"));
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.deleteFBComment(fbc_no);
		
		return "redirect:freeBoardView.do?fb_no="+fb_no;
	}
	
	// ??????????????? ?????? ?????? 10/29
	@RequestMapping("photoBoardDeleteComment.do")
	public String photoBoardDeleteComment(HttpServletRequest request) {
		int pbc_no = Integer.parseInt(request.getParameter("pbc_no"));
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.deletePBComment(pbc_no);
		
		return "redirect:photoBoardView.do?pb_no="+pb_no;
	}
	
	// ??????????????? ????????? ??????????????? ?????? 10/21 ?????????
	@RequestMapping("freeBoardRecommand.do")
	public String freeBoardRecommand(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("client");
		response.setContentType("text/html;charset=utf-8");
		JSONObject obj = new JSONObject();
		if(mdto == null) {
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
			obj.put("msg", "?????????????????? ??????????????? ????????????.");
			obj.put("code", 400);
			response.getWriter().write(obj.toString());
			return null;
		}
<<<<<<< HEAD
		boolean result = fBoardService.insertFBoardRecommand(fb_no, dto.getId());
=======
		boolean result = fBoardService.insertFBoardRecommand(mdto.getId(), fb_no);
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
		String msg = result ? "???????????? ?????????????????????." : "????????? ????????? ?????????????????????.";
		obj.put("msg",msg);
		obj.put("code",200);
		response.getWriter().write(obj.toString());
		return null;
	}
	
	// ??????????????? ?????? ?????? 10/20
	@RequestMapping("freeBoardInsertComment.do")
	public String freeBoardInsertComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// ?????? ?????? ??????

<<<<<<< HEAD
		String fb_comment_content = request.getParameter("fb_comment_content");
		String fb_comment_date = request.getParameter("fb_comment_date");
		
		FBCommentDTO cdto = fBoardService.insertFBComment(new FBCommentDTO(0, 0, null, fb_comment_content, fb_comment_date));
		request.setAttribute("cdto", cdto);
		
		return "redirect:freeBoardView.do";
=======
	// ??????????????? ????????? ??????????????? ?????? ?????? ????????????
	@RequestMapping("photoBoardRecommand.do")
	public String photoBoardRecommand(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("client");
		response.setContentType("text/html;charset=utf-8");
		JSONObject obj = new JSONObject();
		if(mdto == null) {
			obj.put("msg", "?????????????????? ??????????????? ????????????.");
			obj.put("code", 400);
			response.getWriter().write(obj.toString());
			return null;
		}
		boolean result = pBoardService.insertPBoardRecommand(mdto.getId(), pb_no);
		String msg = result ? "???????????? ?????????????????????." : "????????? ????????? ?????????????????????.";
		obj.put("msg",msg);
		obj.put("code",200);
		response.getWriter().write(obj.toString());
		return null;
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	}
	
	// ??????????????? ????????? ????????? ?????? 10/20
	@RequestMapping("freeBoardWriteView.do")
	public String freeBoardWriteView() {
		return "board/fb/freeboard_write";
	}
	
	// ??????????????? ????????? ????????? 10/20
	@RequestMapping("freeBoardWrite.do")
<<<<<<< HEAD
	public String freeBoardWrite(MultipartHttpServletRequest request, HttpSession session) {
		String fb_title = request.getParameter("fb_title");
		String fb_content = request.getParameter("fb_content");
		// String creator_id = ((MemberDTO)session.getAttribute("creator_id")).getId();

		return "redirect:freeBoardList.do";
=======
	public String freeBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("client");
		if(mdto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('????????? ??? ????????? ???????????????.');history.back();</script>");
			return null;
		}
		String fb_title = request.getParameter("fb_title");
		String fb_content = request.getParameter("fb_content");
		String creator_id = ((MemberDTO)session.getAttribute("client")).getId();
		
		int fb_no = fBoardService.insertFBoard(new FBoardDTO(creator_id, 0, fb_title, fb_content, null, null, 0, 0));
		// ???????????? ?????? ??????
		List<MultipartFile> fileList = request.getFiles("file");
		String path = "c:\\fileupload\\"+creator_id+"\\";
		ArrayList<FBFileDTO> flist = new ArrayList<FBFileDTO>();
		
		int i = 1;
		for(MultipartFile mf : fileList) {
			// ?????? ?????????
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if(fileSize == 0) continue;
			//????????? ?????? ?????? ??????
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			//?????? ????????? ?????? ??????
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

	// ??????????????? ????????? ????????? 10/29
	@RequestMapping("photoBoardWrite.do")
	public String photoBoardWrite(MultipartHttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
		MemberDTO mdto = (MemberDTO) request.getSession().getAttribute("client");
		if(mdto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('????????? ??? ????????? ???????????????.');history.back();</script>");
			return null;
		}
		
		String creator_id = ((MemberDTO)session.getAttribute("client")).getId();
		String pb_title = request.getParameter("pb_title");
		String pb_content = request.getParameter("pb_content");
		
		int pb_no = pBoardService.insertPBoard(new PBoardDTO(creator_id, 0, pb_title, pb_content, null, null, 0, 0));
		// ???????????? ?????? ??????
		List<MultipartFile> fileList = request.getFiles("file");
		String path = "c:\\fileupload\\"+creator_id+"\\";
		ArrayList<PBFileDTO> flist = new ArrayList<PBFileDTO>();
		
		int i = 1;
		for(MultipartFile mf : fileList) {
			// ?????? ?????????
			String originalFileName = mf.getOriginalFilename();
			long fileSize = mf.getSize();
			if(fileSize == 0) continue;
			//????????? ?????? ?????? ??????
			SimpleDateFormat format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss");
			int idx = originalFileName.lastIndexOf(".");
			//?????? ????????? ?????? ??????
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
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	}
	
	// ???????????? ?????? ??????(???????????? ????????? / ????????????)
	// ???????????? ?????? ????????? 10/20
	@RequestMapping("price_search.do")
	public String search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String search = request.getParameter("search");//?????????input ?????? ????????????
		response.setContentType("text/html;charset=utf-8");
		ArrayList<ComparisonDTO> searchList = new ArrayList<>();
		searchList = searchApi(search);
		System.out.println(searchList);
		request.setAttribute("searchList", searchList);//api????????? ???????????? request??????
		return "price_comparison";
	}
	
	// ???????????? ???????????? 10/20
	@RequestMapping(value = "seeMore.do")
	public String seeMore(HttpServletRequest request, HttpServletResponse response) {
		String link = request.getParameter("link");
		System.out.println(link);
		ArrayList<ReviewDTO> reviewList = new ArrayList<>();
		reviewList = seeMoreReview(link);//??????????????? ????????? ????????? ???????????? ??????
		request.setAttribute("reviewList", reviewList);//????????????????????? ??????????????? ??????
		return "price_comparison";
	}

	// ??????????????? ?????? ??????????????? ???????????? ???????????? ????????? - 10/22 resource/driver ????????? ???????????? ???????????? ??? ??????, ?????? ????????? 
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static final String WEB_DRIVER_PATH = "/resource/driver/chromedriver";
	
	private ArrayList<ReviewDTO> seeMoreReview(String link){
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//???????????? ????????????
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");

		WebDriver driver = new ChromeDriver(options);

		String url = link;//hidden input?????? ????????? ?????????
		driver.get(url);
		//?????????????????? ????????? ?????????????????? ?????????????????? ????????????????????? ???????????? ?????????????????? ??????????????? ??????
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		//????????????????????? ?????????????????? ??? ???????????? ??????
		List<WebElement> contentList = driver.findElements(By.cssSelector(".YEtwtZFLDz > span"));
		List<WebElement> reviewIdList = driver.findElements(By.cssSelector("._2FmJXrTVEX > strong"));
		List<WebElement> reviewDateList = driver.findElements(By.cssSelector("._2FmJXrTVEX ._3QDEeS6NLn"));
		List<WebElement> reviewSelectList = driver.findElements(By.cssSelector("._3jZQShkMWY > span"));
		List<WebElement> reviewScoreList = driver.findElements(By.cssSelector("._2V6vMO_iLm > em"));
		System.out.println(contentList.size());
		for (Iterator iterator = contentList.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			System.out.println(webElement.getText());

<<<<<<< HEAD
		}
		//review ????????? ????????? dto??????????????? ????????? ???????????? ??????
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
	
	// ????????? ?????? api 10/20
	JSONArray arr;
	private ArrayList<ComparisonDTO> searchApi(String search) {
		String clientId = "_AVjSGJMXRyTaweIE3l0";//?????????????????? ??????????????? ????????????";
        String clientSecret = "hX5FHl3vY6";//?????????????????? ??????????????? ????????????";
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
            //api?????? ?????????????????? ?????? ????????? list?????????
            for (int i = 0; i < arr.length(); i++) {
                JSONObject temp = (JSONObject) arr.get(i);
                if(temp.getString("category2").equals("??????/??????") && !(temp.getString("category3").equals("??????"))) {
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
            throw new RuntimeException("????????? ??????", e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {

        }

        return list;
=======
		return "redirect:photoBoardView.do?pb_no="+pb_no;
	}
	
	// ??????????????? ?????? 10/28
	@RequestMapping("freeBoardDelete.do")
	public String freeBoardDelete(HttpServletRequest request) {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.deleteFBoard(fb_no);
		return "redirect:freeBoardList.do";
	}
	
	// ??????????????? ?????? 10/29
	@RequestMapping("photoBoardDelete.do")
	public String photoBoardDelete(HttpServletRequest request) {
		int pb_no = Integer.parseInt(request.getParameter("pb_no"));
		pBoardService.deletePBoard(pb_no);
		return "redirect:photoBoardList.do";
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	}

	
<<<<<<< HEAD
=======
	// ???????????? ?????? ??????(???????????? ????????? / ????????????)
	// 21/10/21 ?????????
			//???????????? ?????? ?????????
			@RequestMapping("price_search.do")
			public String search(HttpServletRequest request, HttpServletResponse response) throws IOException {
				//search ????????? ????????? search ????????????
				String search = request.getParameter("search");
				//????????? ????????? ????????????
				String sort = request.getParameter("sort");
				response.setContentType("text/html;charset=utf-8");
				//??????????????? dto??? ???????????? ???????????? ??????
				ArrayList<ComparisonDTO> searchList = new ArrayList<ComparisonDTO>();     
				searchList = searchApi(search, sort);
				//request??? searchList ??????
				request.setAttribute("searchList", searchList);
				return "price_comparison";
			}
			//????????? ??????
			@RequestMapping(value = "seeMore.do")
			public String seeMore(HttpServletRequest request, HttpServletResponse response) throws IOException {
				//ajax??? ????????? ?????? ????????? ??????
				String link = request.getParameter("link");
				//?????? ?????????
				System.out.println(link);
				//?????? ?????? ????????? jsonarray ??????
				JSONArray reviewList = new JSONArray();
				reviewList = seeMoreReview(link);
				//??????????????? ?????? ?????? ?????? ?????? ??? jsonobject??? ??????
				JSONObject obj = new JSONObject();
				if(reviewList.length() != 0) {
					obj.put("code", 200); // ?????? ?????????, ?????? 200
					obj.put("responseMessage", "????????? ??????????????? ?????????????????????.");
					obj.put("reviewList", reviewList);
				} else {
					obj.put("code", 500); // ?????? ?????????, ?????? 200
					obj.put("responseMessage", "?????? ????????? ????????????.");
				}
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write(obj.toString());
				return null;
			}
			//???????????? ?????? ?????? ??????
			public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; 
			public static final String WEB_DRIVER_PATH = "/Users/taejin-an/Downloads/chromedriver";
			//??????????????? ???????????? ????????? ?????????
			private JSONArray seeMoreReview(String link) {
				try {
					System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
				} catch (Exception e) {
					e.printStackTrace();
				}
				//???????????? ?????? ??????
				ChromeOptions options = new ChromeOptions();
				//???????????? ?????????
				options.addArguments("headless");

				WebDriver driver = new ChromeDriver(options);
				String url = link;
				driver.get(url);
				//?????? ???????????? ??????????????? ???????????? ?????? URL ?????? ????????????
				String current_url = driver.getCurrentUrl();
				//????????????
				System.out.println(current_url);
				//?????? ????????? ????????? ???????????? ???????????? ?????? ?????????????????? ???????????? 5??? ??????
				try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
				//????????? ??????????????? dto??? ???????????? ??????
				List<WebElement> contentList;
				List<WebElement> reviewIdList;
				List<WebElement> reviewDateList;
				List<WebElement> reviewSelectList;
				List<WebElement> reviewScoreList;
				//???????????? ???????????? ????????????????????? ?????????????????? URL??? ???????????? ???????????? ?????? ?????? ??????
				if(current_url.contains("smartstore")) {
					contentList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list .YEtwtZFLDz ._3QDEeS6NLn"));
					reviewIdList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._2FmJXrTVEX > strong"));
					reviewDateList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._2FmJXrTVEX > span"));
					reviewSelectList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._3jZQShkMWY > span"));
					reviewScoreList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._2V6vMO_iLm > em"));
				} else {
					contentList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._3AGQlpCnyu ._2Xe0HVhCew"));
					reviewIdList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._2DSGiSauFJ > strong"));
					reviewDateList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._2DSGiSauFJ > span"));
					reviewSelectList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._31mfFx_-xd ._2Xe0HVhCew"));
					reviewScoreList = (List<WebElement>) driver.findElements(By.cssSelector(".review_list ._2V6vMO_iLm ._15NU42F3kT"));
					
				}
				
				System.out.println(contentList.size());
				System.out.println(reviewIdList.size());
				System.out.println(reviewDateList.size());
				System.out.println(reviewSelectList.size());
				System.out.println(reviewScoreList.size());
				//???????????? ????????? ????????? ???????????? ???????????? ?????????(????????????)
				for (Iterator iterator = contentList.iterator(); iterator.hasNext();) {
					WebElement webElement = (WebElement) iterator.next();
					System.out.println(webElement.getText()+"\n");
					System.out.println("--------------------");
					
				}
				ArrayList<ReviewDTO> reviewList = new ArrayList<ReviewDTO>();
				
				//reviewdto??? ????????? ??????
				for(int i = 0; i < contentList.size(); i++) {
					reviewList.add(new ReviewDTO(reviewScoreList.get(i).getText(), reviewSelectList.get(i).getText(), contentList.get(i).getText(), reviewIdList.get(i).getText(), reviewDateList.get(i).getText()));
				}
				//list????????? ????????? ????????? ???????????? sysout
				System.out.println(reviewList.size());
				JSONArray review_arr = new JSONArray();
				//???????????? json?????? ??????
				for(int i = 0; i < reviewList.size(); i++) {
					JSONObject obj = new JSONObject();
					obj.put("score", reviewList.get(i).getScore());
					obj.put("reviewContent", reviewList.get(i).getReviewContent());
					obj.put("selectProduct", reviewList.get(i).getSelectProduct());
					obj.put("id", reviewList.get(i).getId());
					obj.put("reviewDate", reviewList.get(i).getReviewDate());
					review_arr.put(obj);
				}
				//driver close
				driver.close();
				driver.quit();

				return review_arr; 
			}

			JSONArray arr;
			//?????? api ??????
			private ArrayList<ComparisonDTO> searchApi(String search, String sort) {
				String clientId = "_AVjSGJMXRyTaweIE3l0";//?????????????????? ??????????????? ????????????";
		        String clientSecret = "hX5FHl3vY6";//?????????????????? ??????????????? ????????????";
		        ArrayList<ComparisonDTO> list = new ArrayList<ComparisonDTO>();
		        String msg = null;
		        HttpURLConnection con = null;
		        BufferedReader br = null;
		        String result = "";
		        String text = search;
		        try {
		            text = URLEncoder.encode(text, "UTF-8");
		            sort = URLEncoder.encode(sort, "UTF-8");


		            URL url = new URL("https://openapi.naver.com/v1/search/shop.json?query=" + text + "&display=100&sort=" + sort);
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
		            for (int i = 0; i < arr.length(); i++) {
		                JSONObject temp = (JSONObject) arr.get(i);
		                if(temp.getString("category2").equals("??????/??????") && !(temp.getString("category3").equals("??????"))) {
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
		            throw new RuntimeException("????????? ??????", e);
		        } catch (MalformedURLException e) {
		            e.printStackTrace();
		        } catch (IOException e) {
		            e.printStackTrace();
		        } finally {

		        }

		        return list;
			}
	
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	// ???????????? ?????? ??????(?????????-????????? / ????????????)
	// ????????? ????????? ????????? ?????? 10/22
	@RequestMapping("naver.do")
	public String naverLoginView() {
		return "social/naver_login";
	}
	// ????????? ?????? ????????? ?????? 10/22
	@RequestMapping("callback.do")
	public String navercallbackView() {
		return "social/naver_callback";
	}
	// ???????????? ????????? ?????? 10/22
	@RequestMapping("register.do")
	public String registerView() {
		return "register/register";
	}
	//Leafy ???????????? ?????? 10/22
	@RequestMapping("LeafyMain.do")
	public String leafyMainView() {
		return "register/leafy_main";
	}
	//???????????? ???????????? ?????? 10/22
	@RequestMapping("LeafyEvent.do")
	public String leafyEventView() {
		return "register/leafy_event";
	}
	//???????????? ???????????? ?????? 10/22
	@RequestMapping("LeafyPrivacy.do")
	public String leafyPrivacyView() {
		return "register/leafy_privacy";
	}
	
	//?????? ????????? ?????? ( ????????? ?????? )
	@RequestMapping("Maingo.do")
	public String MainView(HttpServletRequest request, HttpSession httpSession) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);
		
		//???????????????
		ArrayList<FBoardDTO> fbList = fBoardService.selectAllFBoard(currentPageNo);
		request.setAttribute("fbList", fbList);
		
		//????????????
		ArrayList<TBoardDTO> tblist = tBoardService.selectAllTip(currentPageNo);
		request.setAttribute("tblist", tblist);
<<<<<<< HEAD
		
		//?????? ????????? 
		ArrayList<PBoardDTO> pbList = pBoardService.selectAllPBoard(currentPageNo);
		request.setAttribute("pbList", pbList);
=======

		// ????????? ??????
		int count = tBoardService.selectTipBoardCount();
		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 5);
		request.setAttribute("pagging", vo);

		return "board/tb/tip_list";
	}
	// ??? ????????? ??????
		@RequestMapping("tipBoardSearch.do")
		public String tipBoardSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
		
		// ??? ????????? ?????? ?????????
		@RequestMapping("tipBoardView.do")
		public String tipBoardView(HttpServletRequest request, HttpSession session) {
			int tno = Integer.parseInt(request.getParameter("tno"));
			tBoardService.addTipBoardCount(tno);
			TBoardDTO dto = tBoardService.selectTipBoardContent(tno);
			request.setAttribute("tBoard", dto);
			
			List<TBCommentDTO> tclist = tBoardService.selectTipBoardComment(tno);
			request.setAttribute("tclist", tclist);
			System.out.println(tclist);
			
			return "board/tb/tip_view";
		}
		
		// ??? ????????? ??????
		@RequestMapping("tipRecommand.do")
		public String tipRecommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
			int tno = Integer.parseInt(request.getParameter("tno"));
			MemberDTO dto = (MemberDTO) request.getSession().getAttribute("client");
			response.setContentType("text/html;charset=utf-8");
			JSONObject obj = new JSONObject();
			if(dto == null) {
				obj.put("msg", "???????????? ??????????????????.");
				obj.put("code", 400);
				response.getWriter().write(obj.toString());
				return null;
			}
			boolean result = tBoardService.insertTipRecommand(tno, dto.getId());
			String msg = result ? "???????????? ??????????????????." : "????????? ??????????????????.";
			obj.put("msg",msg);
			obj.put("code",200);
			response.getWriter().write(obj.toString());

			return null;
		}
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
		
		return "main/main";
	}
	
	// ???????????? ?????? ??????(??? ????????? / ???????????? - ????????????,??????)
	// TIP ????????? ?????? 10/22
	@RequestMapping("TipBoardList.do")
	public String TipBoardList(HttpServletRequest request, HttpSession session) {
//		String pageNo = request.getParameter("pageNo");
//		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<TBoardDTO> list = tBoardService.selectAllTBoard(1);
		request.setAttribute("list", list);
		
		//????????? ??????
//		int count = tBoardService.selectTBoardCount();
//		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 5);
//		request.setAttribute("pagging", vo);

		return "board/tb/tip_list";
	}
	// ??? ????????? ?????? 10/22
//		@RequestMapping("TipBoardSearch.do")
//		public String freeBoardSearch(HttpServletRequest request, HttpServletResponse response) throws JSONException, IOException {
//			String kind = request.getParameter("kind");
//			String search = request.getParameter("search");
//			
//			List<TBoardDTO> list = tBoardService.selectTBoard(kind, search);
//			JSONArray arr = new JSONArray();
//			for(int i=0;i<list.size();i++) {
//				JSONObject temp = new JSONObject();
//				temp.put("tb_no", list.get(i).getTb_no());
//				temp.put("tb_addfile_url", list.get(i).getTb_addfile_url());
//				temp.put("tb_title", list.get(i).getTb_title());
//				temp.put("tb_content", list.get(i).getTb_content());
//				temp.put("id", list.get(i).getId());
//				temp.put("tb_visit", list.get(i).getTb_visit());
//				temp.put("tb_recommand", list.get(i).getTb_recommand());
//				temp.put("tb_comment", list.get(i).getTb_comment());
//				temp.put("tb_date", list.get(i).getTb_date());
//				
//				arr.put(temp);
//			}
//			JSONObject obj = new JSONObject();
//			if(list.size() != 0) {
//				obj.put("code", 200); // ?????? ?????????, ?????? 200
//				obj.put("responseMessage", "????????? ??????????????? ?????????????????????.");
//				obj.put("result", arr);
//			} else {
//				obj.put("code", 500); // ?????? ?????????, ?????? 500
//				obj.put("responseMessage", "?????? ????????? ????????????.");
//			}
//			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().write(obj.toString());
//			
//			return null;
//		}
	
	//???????????? ????????? ?????? 10/22
	@RequestMapping("NoticeList.do")
	public String boardMain(HttpServletRequest request) {
		ArrayList<NoticeDTO> noticelist = noticeService.selectNotice(1);
		request.setAttribute("noticelist", noticelist);
		return "board/notice_list";
	}
	
	// ???????????? ?????? ??????(?????? ?????????)
	// ??????????????? ??????
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
	

	
	
	@RequestMapping("Login.do")
	public String Login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
							
	    MemberDTO dto = loginService.Login(id, passwd);

		if (dto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('????????? ???????????? ???????????????'); history.back();</script>");
			return null;
		} else {
			request.getSession().setAttribute("client", dto);
			return MainView(request,request.getSession());
		}
		
	}
	
	@RequestMapping("memverRegister.do")
	public String joingo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String nickname = request.getParameter("nickname");
		String name = request.getParameter("name");
		String pno = request.getParameter("pno1")+request.getParameter("pno2");//???????????? ????????? 
		int gender = Integer.parseInt(request.getParameter("gender"));
		String address = request.getParameter("address")+request.getParameter("address_2");
		String phone =request.getParameter("pon_1")+request.getParameter("pon_2")+request.getParameter("pon_3");//????????? ?????????
		String email = request.getParameter("E_mail_1")+"@"+request.getParameter("E_mail_2");				
		MemberDTO dto = new MemberDTO(id, passwd, nickname, name, pno,0, address, phone, email,0,0);
		loginService.insertMember(dto);
		request.getSession().setAttribute("client", dto);			
			return index();
		}
	
<<<<<<< HEAD
//		
//	@RequestMapping("naver.do")
//	private void naverLogin(HttpServletRequest request,HttpServletResponse response) throws IOException{
//		String code = request.getParameter("resultcode");
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String mobile = request.getParameter("mobile");
//		NaverDTO dto = new NaverDTO(name, mobile, code, mobile, id);
//		
//	}
=======
	@RequestMapping(value = "/message_list.do")
	public String message_list(HttpServletRequest request, HttpSession session) {
		String nick = (String) session.getAttribute("nick");
		
		messageDTO dto = new messageDTO();
		dto.setNick(nick);
		
		ArrayList<messageDTO> list = messageService.messageList(dto);
		
		request.setAttribute("list", list);
		return "message_list";
	}
	
	@RequestMapping(value = "/message_ajax_list.do")
	public String message_ajax_list(HttpServletRequest request, HttpSession session) {
		
		String nick = (String) session.getAttribute("nick");
		
		messageDTO dto = new messageDTO();
		dto.setNick(nick);
		
		ArrayList<messageDTO> list = messageService.messageList(dto);
		
		request.setAttribute("list", list);
		
		return "message_ajax_list";
	}
	
	@RequestMapping(value = "/message_content_list.do")
	public String message_content_list(HttpServletRequest request, HttpSession session) {
		
		int room = Integer.parseInt(request.getParameter("room"));
		
		messageDTO dto = new messageDTO();
		dto.setRoom(room);
		dto.setNick((String) session.getAttribute("nick"));
		
		//????????? ????????? ????????????.
		ArrayList<messageDTO> clist = messageService.roomContentList(dto);
		
		request.setAttribute("clist", clist);
		
		return "message_content_list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/message_send_inlist.do")
	public int message_send_inlist(@RequestParam int room, @RequestParam String other_nick, @RequestParam String content, HttpSession session) {
		
		messageDTO dto = new messageDTO();
		dto.setRoom(room);
		dto.setSend_nick((String) session.getAttribute("nick"));
		dto.setRecv_nick(other_nick);
		dto.setContent(content);
		
		int flag = messageService.messageSendInlist(dto);
		return flag;
	}
>>>>>>> e0341cde40e4491d6bd30cdd20ed1e1696e78b9a
	
	
	

	
	
	
	
	
}


