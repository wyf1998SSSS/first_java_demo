package com.llk.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.llk.dao.IPaperDao;
import com.llk.dao.impl.PaperDaoImpl;
import com.llk.service.IPaperService;
import com.llk.util.Json;
import com.llk.util.PaperJson;
import com.llk.vo.Paper;

public class PaperServiceImpl implements IPaperService{
	private IPaperDao paperDao = new PaperDaoImpl();
	@Override
	public Boolean savePaper(Paper paper) {
		// TODO Auto-generated method stub
		return paperDao.savePaper(paper);
	}
	@Override
	//用来得到考试页面所需的试题
	public Json searchPaper(int paperType) {
		int paperNum = 0;
		Json result = new Json();
		List<Paper> paperList= paperDao.searchPaper(paperType);
		Set<PaperJson> paperSet = new HashSet<PaperJson>();
		System.out.println(paperList.size());
		for(int i = 0;i<paperList.size();i++){
			if(paperNum>4){
				
				break;
			}else{
				/*System.out.println(paperList.get(i).getQuestionName());*/
//				paperSet.add(paperList.get(i));
				PaperJson paperJson = new PaperJson();
				Paper paper = paperList.get(i);
				paperJson.setQuestion(paper.getQuestionName());
				paperJson.setCorrectAnswer(paper.getCorrectAnswer());
				String answers[] = new String[4];
				answers[0] = paper.getAnswerA();
				answers[1] = paper.getAnswerB();
				answers[2] = paper.getAnswerC();
				answers[3] = paper.getAnswerD();
				paperJson.setAnswers(answers);
				paperSet.add(paperJson);
				paperNum++;
			}
		}
		result.setObj(paperSet);
		result.setSuccess(true);
		
	
		return result;
	}
	@Override
	//用以试题页面展示试题列表
	public Json getPaperList(int paperType) {
		// TODO Auto-generated method stub
		return null;
	}
}


	