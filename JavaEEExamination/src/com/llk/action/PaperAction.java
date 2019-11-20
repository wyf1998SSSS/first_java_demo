package com.llk.action;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.google.gson.Gson;
import com.llk.service.IPaperService;
import com.llk.service.impl.PaperServiceImpl;
import com.llk.util.Json;
import com.llk.util.PaperJson;
import com.llk.vo.Paper;
import com.llk.vo.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PaperAction extends ActionSupport implements ModelDriven<Paper>{
	private Paper paper = new Paper();
	private IPaperService paperService = new PaperServiceImpl();
	@Override
	public Paper getModel() {
		// TODO Auto-generated method stub
		return paper;
	}
	public String showJavaTestView(){
		ServletActionContext.getRequest().getSession().setAttribute("paperType", 0);
		return "showTestView";
	}
	public String showJsTestView(){
		
		ServletActionContext.getRequest().getSession().setAttribute("paperType", 1);
		return "showTestView";
	}
	public String showSavePaperView(){
		return "showSavePaperView";
	}
	public String savePaper() throws IOException{
		Boolean success = paperService.savePaper(paper);
		System.out.println(success);
		if(success){
			/*ServletActionContext.getRequest().getSession().setAttribute("paperIsSaved", "true");*/
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.getWriter().print("true");
			
		}else{
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.getWriter().print("false");
		}
		return NONE;
	}
	public String searchPaper(){
		int paperType = (Integer) ServletActionContext.getRequest().getSession().getAttribute("paperType");
		Json result = paperService.searchPaper(paperType);
		String resultStr = new Gson().toJson(result);
		if(result.isSuccess()){
			try {
				ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
				ServletActionContext.getResponse().getWriter().println(resultStr);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return NONE;
	}
	public String getPaperList(){
		return NONE;
	}
}
