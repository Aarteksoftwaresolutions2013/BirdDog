package com.birddog.controller.ws;

import java.text.ParseException;
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

import com.birddog.model.Attachment;
import com.birddog.model.Lead;
import com.birddog.service.AttachmentService;
import com.birddog.service.LeadService;
import com.birddog.util.ConstantMessage;
import com.birddog.util.ConstantURL;
import com.birddog.util.IConstant;

@Controller
public class LeadWsController {

	@Autowired
	private LeadService leadService;
	
	@Autowired
	private AttachmentService attachmentService;

	@RequestMapping(value = "/getAllLead", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> getAllLead(@RequestBody Lead lead, HttpServletResponse response,ModelMap model) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		List<Lead> leadList = leadService.getAllLeadById(lead.getBirddog().getId());
		if (leadList != null && !leadList.isEmpty()) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, leadList);
			map.put(IConstant.MESSAGE, ConstantMessage.ALL_LEAD_LIST);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, leadList);
			map.put(IConstant.MESSAGE, ConstantMessage.NO_LEAD_FOUND);
		}
		return map;
	}
	
	@RequestMapping(value = "/saveLeadDetails", method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> saveLeadDetails(@RequestBody Lead lead, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Lead leadDetail = leadService.saveLeadDetail(lead);
		if (leadDetail != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.LEAD_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.LEAD_FAILUR_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.UPDATE_LEAD_DETAIL_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> updateLeadDetail(@RequestBody Lead lead, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		Lead leadDetail = leadService.saveLeadDetail(lead);
		if (leadDetail != null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.UPDATE_LEAD_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.UPDATE_LEAD_FAILUR_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.DELETE_LEAD_DETAIL_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> deleteLeadDetail(@RequestBody Lead lead, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();

		boolean leadDetails = leadService.deleteLead(lead.getId());
		if (leadDetails) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.DELETE_SUCCESS_MESSAGE);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.DELETE_FAILUR_MESSAGE);
		}
		return map;
	}
	
	@RequestMapping(value = ConstantURL.SEARCH_LEAD_DATE_WISE_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> searchLeadDateWise(@RequestBody Lead lead, HttpServletResponse response) throws ParseException {
		Map<Object, Object> map = new HashMap<Object, Object>();

		List<Lead> leadList = leadService.getAllLeadDateWise(lead.getFromDate(),lead.getToDate());
		if (leadList!=null) {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.DATA, leadList);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.DATA, leadList);
		}
		return map;
	}
	
	
	@RequestMapping(value = ConstantURL.VIEW_SINGLE_LEAD_WS, method = RequestMethod.POST)
	public @ResponseBody Map<Object, Object> viewSingleLead(@RequestBody Lead lead, HttpServletResponse response) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		Lead leadDetail = leadService.viewSingleLeadDetails(lead.getId());
		if (leadDetail != null) {
			List<Attachment> attachmentList = attachmentService.getAllAttachment(leadDetail.getId());
			if(attachmentList!=null && !attachmentList.isEmpty()){
			for(Attachment attachment:attachmentList){
			attachment.setPath(IConstant.BIRDDOG_IMAGES+attachment.getPath());
			attachment.getLead().getBirddog().setReInvestor(null);
			}
			}
			
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_SUCCESS_MESSAGE);
			map.put(IConstant.MESSAGE, leadDetail);
		} else {
			map.put(IConstant.RESPONSE, IConstant.RESPONSE_NO_DATA_MESSAGE);
			map.put(IConstant.MESSAGE, ConstantMessage.RECORD_NOT_FOUND);
		}
		return map;
	}
}
