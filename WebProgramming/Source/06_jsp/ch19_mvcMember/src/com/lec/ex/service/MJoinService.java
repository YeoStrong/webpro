package com.lec.ex.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lec.ex.dao.MemberDao;
import com.lec.ex.dto.MemberDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MJoinService implements Service {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String path = request.getSession().getServletContext().getRealPath("memberPhotoUp");
		int maxSize = 1024*1024*1;
		String filename = "";
		MemberDao mDao = new MemberDao();
		MemberDto mDto = new MemberDto();
		MultipartRequest mRequest = null;
		int result = 0;
		try{
			mRequest = new MultipartRequest(request, path, maxSize, "utf-8", new DefaultFileRenamePolicy());	
			Enumeration<String> paramNames = mRequest.getFileNames();
			// while(paramNames.hasMoreElements()){ // 첨부파일 1개라 not need
				String param = paramNames.nextElement();
				filename = mRequest.getFilesystemName(param);
			// }
			String mid = mRequest.getParameter("mid");
			String mpw = mRequest.getParameter("mpw");
			String mname = mRequest.getParameter("mname");
			String memail = mRequest.getParameter("memail");
			String mphoto = filename!=null? filename:"NOIMG.jpg";
			String maddress = mRequest.getParameter("maddress");
			String mbirthStr = mRequest.getParameter("mbirth");
			Date mbirth = null;
			if(!mbirthStr.equals("")) {
				mbirth = Date.valueOf(mbirthStr);			
			}
			mDto.setMid(mid);
			mDto.setMpw(mpw);
			mDto.setMname(mname);
			mDto.setMemail(memail);
			mDto.setMphoto(mphoto);
			mDto.setMaddress(maddress);
			mDto.setMbirth(mbirth);
			result = mDao.confirmId(mid);
			if(result == MemberDao.NONEXISTENT) { // 가입 가능한 mID이까 회원가입
				MemberDto member = new MemberDto(mid, mpw, mname, memail, 
						mphoto, mbirth, maddress, null);
				// 회원가입
				result = mDao.join(member);
				if(result == MemberDao.SUCCESS) {
					HttpSession session = request.getSession(); // 세션은 request로 부터
					session.setAttribute("mid", mid);
					request.setAttribute("joinResult", "회원가입이 완료되었습니다");
				}else {
					request.setAttribute("joinErrorMsg", "정보가 너무 길어서 회원가입 실패");
				}
			}else {
				request.setAttribute("joinErrorMsg", "중복된 ID는 회원가입이 불가합니다");
			}
		} catch(IOException e){
			System.out.println(e.getMessage());
			request.setAttribute("joinErrorMsg", "첨부파일 용량이 너무 큽니다. 1mb 이하의 파일을 업로드 하세요");
		}
		// 서버에 업로드 한 후 소스폴더로 file copy
		InputStream is = null;
		OutputStream os = null;
		try{
			File serverFile = new File(path + "/" + filename);
			if(serverFile.exists() && !filename.equals("NOIMG.jpg") && result == MemberDao.SUCCESS){
				is = new FileInputStream(serverFile); // 서버에 업로드 된 파일
				os = new FileOutputStream("D:/YeosongYoon/WebProgramming/Source/06_jsp/ch19_mvcMember/WebContent/memberPhotoUp/" + filename); // 소스폴더로 복사될 파일
				byte [] bs = new byte[(int)serverFile.length()];
				while(true){
					int nReadCnt = is.read(bs);
					if(nReadCnt == -1) break;
					os.write(bs, 0, nReadCnt);
				}
				System.out.println("서버에 업로드한 파일을 소스폴더로 복사 완료");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			try{
				if(os!=null) os.close();
				if(is!=null) is.close();
			}catch(IOException e){
				System.out.println(e.getMessage());
			}
		}
	}
}
