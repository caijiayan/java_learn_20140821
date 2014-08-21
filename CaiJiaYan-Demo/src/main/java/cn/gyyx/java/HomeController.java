package cn.gyyx.java;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.gyyx.java.Model.*;
import cn.gyyx.java.BLL.*;

/**
 * Handles requests for the application home page.
 *  <label>区服：</label><select id="selectServer"><option value="-1">请选择区服</option></select>
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private GameBLL gameBll=new GameBLL();
	private ServerBLL serverBll=new ServerBLL();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model,int gameId) {
		logger.info("Hello World! {}.", gameId);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		List<GameInfo> gameList = gameBll.queryList();
		
		if(gameId<=0){
			gameId=1;
		}
		logger.info("come on {}",gameId);
		List<ServerInfo> serverList = serverBll.queryListByGameId(gameId);
		model.addAttribute("serverList",serverList);
		model.addAttribute("gameId",gameId);
		
		model.addAttribute("gameList",gameList);
		model.addAttribute("serverTime", formattedDate );
		
		
		return "home";
	}
	
	/*
	 * 根据游戏ID获取区服列表
	 */
	@RequestMapping(value = "/getServerListByGameId", method = RequestMethod.GET)
	public @ResponseBody List<ServerInfo> getServerListByGameId(
			@RequestParam("gameId") int gameId) {
		
		List<ServerInfo> list = serverBll.queryListByGameId(gameId);
		logger.info("getServerListByGameId{}",list.size());
		return list;
	}
	
	
	/*
	 * 添加区服
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public @ResponseBody String insert(
			@RequestParam("gameId") int gameId,
			@RequestParam("serverName") String serverName ) {
		
		ServerInfo info = new ServerInfo();
		info.setGameId(gameId);
		info.setServerName(serverName);
		
		int count= serverBll.insert(info);
		
		return count+",home";
	}
	
}
