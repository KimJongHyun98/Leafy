package com.plant;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
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

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.openqa.selenium.Alert;
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

import com.beust.jcommander.internal.Console;
import com.plant.dto.ComparisonDTO;
import com.plant.dto.FBCommentDTO;
import com.plant.dto.FBoardDTO;
import com.plant.dto.MemberDTO;
import com.plant.dto.NaverDTO;
import com.plant.dto.NoticeDTO;
import com.plant.dto.PBoardDTO;
import com.plant.dto.PCBoardDTO;
import com.plant.dto.PaggingVO;
import com.plant.dto.ReviewDTO;
import com.plant.dto.TBoardDTO;
import com.plant.service.FBoardService;
import com.plant.service.LoginService;
import com.plant.service.MainService;
//import com.plant.service.MainService;
import com.plant.service.MemberService;
import com.plant.service.NoticeService;
import com.plant.service.PBoardService;
import com.plant.service.PCBoardService;
import com.plant.service.TBoardService;

@Controller
public class MainController { // 메인컨트롤러
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
	
	// 오형석 기능 부분(자유게시판 / 포토게시판)
	// 페이지 이동 10/20
	@RequestMapping("/") 
	public String index() {
		return "index";
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
	
	// 자유게시판 상세 게시글 10/21
	@RequestMapping("freeBoardView.do")
	public String freeBoardView(HttpServletRequest request, HttpSession session) {
		// 상세 게시글 출력
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		fBoardService.addFBoardCount(fb_no);
		FBoardDTO dto = fBoardService.selectFBoardContent(fb_no);
		request.setAttribute("fBoard", dto);
		
		// 댓글 출력창
		List<FBCommentDTO> fbclist = fBoardService.selectFBoardComment(fb_no);
		request.setAttribute("fbclist", fbclist);
		System.out.println(fbclist);
		
		return "board/fb/freeboard_view";
	}
	
	// 자유게시판 게시글 추천올리는 기능 10/21
	@RequestMapping("freeBoardRecommand.do")
	public String freeBoardRecommand(HttpServletRequest request, HttpServletResponse response) throws IOException, JSONException {
		int fb_no = Integer.parseInt(request.getParameter("fb_no"));
		MemberDTO dto = (MemberDTO) request.getSession().getAttribute("client");
		response.setContentType("text/html;charset=utf-8");
		JSONObject obj = new JSONObject();
		if(dto == null) {
			obj.put("msg", "로그인하셔야 이용하실수 있습니다.");
			obj.put("code", 400);
			response.getWriter().write(obj.toString());
			return null;
		}
		boolean result = fBoardService.insertFBoardRecommand(fb_no, dto.getId());
		String msg = result ? "게시글을 추천하였습니다." : "게시글 추천을 취소하였습니다.";
		obj.put("msg",msg);
		obj.put("code",200);
		response.getWriter().write(obj.toString());

		return null;
	}
	
	// 자유게시판 댓글 입력 10/20
	@RequestMapping("freeBoardInsertComment.do")
	public String freeBoardInsertComment(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		// 댓글 입력 요소

		String fb_comment_content = request.getParameter("fb_comment_content");
		String fb_comment_date = request.getParameter("fb_comment_date");
		
		FBCommentDTO cdto = fBoardService.insertFBComment(new FBCommentDTO(0, 0, null, fb_comment_content, fb_comment_date));
		request.setAttribute("cdto", cdto);
		
		return "redirect:freeBoardView.do";
	}
	
	// 자유게시판 글쓰기 페이지 이동 10/20
	@RequestMapping("freeBoardWriteView.do")
	public String freeBoardWriteView() {
		return "board/fb/freeboard_write";
	}
	
	// 자유게시판 글쓰기 페이지 10/20
	@RequestMapping("freeBoardWrite.do")
	public String freeBoardWrite(MultipartHttpServletRequest request, HttpSession session) {
		String fb_title = request.getParameter("fb_title");
		String fb_content = request.getParameter("fb_content");
		// String creator_id = ((MemberDTO)session.getAttribute("creator_id")).getId();

		return "redirect:freeBoardList.do";
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
		return "social/naver_login";
	}
	// 네이버 콜백 페이지 이동 10/22
	@RequestMapping("callback.do")
	public String navercallbackView() {
		return "social/naver_callback";
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
	
	//메인 페이지 이동 ( 자유만 완료 )
	@RequestMapping("Maingo.do")
	public String MainView(HttpServletRequest request, HttpSession httpSession) {
		String pageNo = request.getParameter("pageNo");
		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);
		
		//자유게시판
		ArrayList<FBoardDTO> fbList = fBoardService.selectAllFBoard(currentPageNo);
		request.setAttribute("fbList", fbList);
		
		//팁게시판
		ArrayList<TBoardDTO> tblist = tBoardService.selectAllTip(currentPageNo);
		request.setAttribute("tblist", tblist);
		
		//포토 게시판 
		ArrayList<PBoardDTO> pbList = pBoardService.selectAllPBoard(currentPageNo);
		request.setAttribute("pbList", pbList);
		
		return "main/main";
	}
	
	// 안세영님 기능 부분(팁 게시판 / 고객센터 - 공지사항,문의)
	// TIP 게시판 출력 10/22
	@RequestMapping("TipBoardList.do")
	public String TipBoardList(HttpServletRequest request, HttpSession session) {
//		String pageNo = request.getParameter("pageNo");
//		int currentPageNo = pageNo == null || pageNo.equals("") ? 1 : Integer.parseInt(pageNo);

		ArrayList<TBoardDTO> list = tBoardService.selectAllTBoard(1);
		request.setAttribute("list", list);
		
		//게시글 개수
//		int count = tBoardService.selectTBoardCount();
//		PaggingVO vo = new PaggingVO(count, currentPageNo, 5, 5);
//		request.setAttribute("pagging", vo);

		return "board/tb/tip_list";
	}
	// 팁 게시판 검색 10/22
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
//				obj.put("code", 200); // 검색 성공시, 코드 200
//				obj.put("responseMessage", "조회가 정상적으로 진행되었습니다.");
//				obj.put("result", arr);
//			} else {
//				obj.put("code", 500); // 검색 실패시, 코드 500
//				obj.put("responseMessage", "조회 결과가 없습니다.");
//			}
//			response.setContentType("text/html;charset=utf-8");
//			response.getWriter().write(obj.toString());
//			
//			return null;
//		}
	
	//공지사항 게시판 출력 10/22
	@RequestMapping("NoticeList.do")
	public String boardMain(HttpServletRequest request) {
		ArrayList<NoticeDTO> noticelist = noticeService.selectNotice(1);
		request.setAttribute("noticelist", noticelist);
		return "board/notice_list";
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
	

	
	
	@RequestMapping("Login.do")
	public String Login(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
							
	    MemberDTO dto = loginService.Login(id, passwd);

		if (dto == null) {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("<script>alert('아이디 비밀번호 확인하세요'); history.back();</script>");
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
		String pno = request.getParameter("pno1")+request.getParameter("pno2");//주민번호 합치기 
		int gender = Integer.parseInt(request.getParameter("gender"));
		String address = request.getParameter("address")+request.getParameter("address_2");
		String phone =request.getParameter("pon_1")+request.getParameter("pon_2")+request.getParameter("pon_3");//폰번호 합치기
		String email = request.getParameter("E_mail_1")+"@"+request.getParameter("E_mail_2");				
		MemberDTO dto = new MemberDTO(id, passwd, nickname, name, pno,0, address, phone, email,0,0);
		loginService.insertMember(dto);
		request.getSession().setAttribute("client", dto);			
			return index();
		}
	
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
	
	
	

	
	
	
	
	
}


