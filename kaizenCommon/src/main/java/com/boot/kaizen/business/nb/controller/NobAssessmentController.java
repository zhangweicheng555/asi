package com.boot.kaizen.business.nb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.boot.kaizen.business.nb.model.NobAssessment;
import com.boot.kaizen.business.nb.service.INobAssessmentService;
import com.boot.kaizen.entity.LoginUser;
import com.boot.kaizen.entity.RequestParamEntity;
import com.boot.kaizen.util.JsonMsgUtil;
import com.boot.kaizen.util.MyUtil;
import com.boot.kaizen.util.TableResultUtil;
import com.boot.kaizen.util.UserUtil;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 达标评估测试结果
 * 
 * @author weichengz
 * @date 2019年4月22日 下午1:30:56
 */
@Controller
@RequestMapping("/nb/assessment")
public class NobAssessmentController {

	@Autowired
	private INobAssessmentService nobAssessmentService;

	@ResponseBody
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public TableResultUtil find(RequestParamEntity param) {

		param.getMap().put("projId", MyUtil.getDealProjId(UserUtil.getLoginUser()));

		PageInfo<NobAssessment> pageInfo = PageHelper.startPage(param.getPage(), param.getLimit())
				.doSelectPageInfo(new ISelect() {
					@Override
					public void doSelect() {
						nobAssessmentService.query(param.getMap());
					}
				});
		return new TableResultUtil(0l, "操作成功", pageInfo.getTotal(), pageInfo.getList());
	}

	/**
	 * 
	 * @Description: 编辑
	 * @author weichengz
	 * @date 2019年2月17日 下午11:13:19
	 */
	@ResponseBody
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public JsonMsgUtil edit(NobAssessment nobAssessment) {
		LoginUser loginUser = UserUtil.getLoginUser();
		return nobAssessmentService.edit(nobAssessment, loginUser);
	}

	/**
	 * 
	 * @Description: 通过任务id查询
	 * @author weichengz
	 * @date 2019年2月17日 下午11:13:03
	 */
	@ResponseBody
	@RequestMapping(value = "/findById", method = RequestMethod.POST)
	public JsonMsgUtil findById(@RequestParam("id") String id) {
		return nobAssessmentService.findById(id);
	}

	/**
	 * 
	 * @Description: 删除
	 * @author weichengz
	 * @date 2019年2月17日 下午11:13:10
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public JsonMsgUtil delete(@RequestParam("ids") String ids) {
		return nobAssessmentService.delete(ids);
	}

}
