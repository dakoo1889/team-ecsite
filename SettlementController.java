package jp.co.internous.sunflower.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.sunflower.model.domain.MstDestination;
import jp.co.internous.sunflower.model.mapper.MstDestinationMapper;
import jp.co.internous.sunflower.model.mapper.TblCartMapper;
import jp.co.internous.sunflower.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.sunflower.model.session.LoginSession;

@Controller
@RequestMapping("/sunflower/settlement")
public class SettlementController {
	@Autowired
	 MstDestinationMapper mstDestinationMapper;
	
	@Autowired
	LoginSession loginSession;
	
	@Autowired
	TblPurchaseHistoryMapper tblPurchaseHistoryMapper;
	
	@Autowired
	private TblCartMapper cartMapper;
	
	
	Gson gson = new Gson();
	
	
	@RequestMapping("/")
	public String settlement(Model m) {
				
		//DBからラジオ、宛先氏名、住所、住所、電話番号を取得　※ログインしているユーザーのデータのみ
		List<MstDestination> mstDestinationList = mstDestinationMapper.findByUserId(loginSession.getUserId() ) ;
				m.addAttribute("mstDestinationList", mstDestinationList);
		return "settlement";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/complete")
	@ResponseBody
	public boolean complete(@RequestBody String destinationId) {

		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		int id = Integer.parseInt(map.get("destinationId"));
		
		long userId = loginSession.getUserId();

		long insertCount = tblPurchaseHistoryMapper.insert(id, userId);
		
		long deleteCount = 0;
		if (insertCount > 0) {
			deleteCount = cartMapper.deleteByUserId(userId);
		}
		
		return deleteCount == insertCount;
	}
	
}

