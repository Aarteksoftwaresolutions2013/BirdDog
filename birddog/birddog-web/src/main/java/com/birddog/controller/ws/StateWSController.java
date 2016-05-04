package com.birddog.controller.ws;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.birddog.model.City;
import com.birddog.model.County;
import com.birddog.model.State;
import com.birddog.service.CityService;
import com.birddog.service.CountyService;
import com.birddog.service.StateService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class StateWSController {
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountyService countyService;
	
	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = ConstantURL.STATE_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllState(@RequestBody State state, HttpServletResponse response,ModelMap model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<State> stateList = stateService.getAllStates();
		if (stateList != null && !stateList.isEmpty()) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, stateList);	
			map.put(IConstant.MESSAGE, ConstantMessage.ALL_STATE_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.NO_STATE_FOUND);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.GET_COUNTY_BY_STATE_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllCounty(@RequestBody State state, HttpServletResponse response,ModelMap model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<County> countyList = countyService.findCountyByStateId(state.getId());
		if (countyList != null && !countyList.isEmpty()) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, countyList);	
			map.put(IConstant.MESSAGE, ConstantMessage.ALL_COUNTY_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.NO_COUNTY_FOUND);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.GET_CITY_BY_COUNTY_URL, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllCity(@RequestBody County county, HttpServletResponse response,ModelMap model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<City> cityList = cityService.findCityByCountyId(county.getId());
		if (cityList != null && !cityList.isEmpty()) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, cityList);	
			map.put(IConstant.MESSAGE, ConstantMessage.ALL_CITY_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.NO_CITY_FOUND);
		}
		return map;
	}
}
