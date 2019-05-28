package com.boot.kaizen.business.nb.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.boot.kaizen.business.nb.model.NobPlan;
import com.boot.kaizen.business.nb.service.INobPlanService;
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
 * NB工参信息
 * 
 * @author weichengz
 * @date 2019年4月22日 下午1:30:56
 */
@Controller
@RequestMapping("/nb/plan")
public class NobPlanController {

	@Autowired
	private INobPlanService nobPlanService;

	@ResponseBody
	@RequestMapping(value = "/find", method = RequestMethod.POST)
	public TableResultUtil find(RequestParamEntity param) {
		param.getMap().put("projId", MyUtil.getDealProjId(UserUtil.getLoginUser()));
		PageInfo<NobPlan> pageInfo = PageHelper.startPage(param.getPage(), param.getLimit())
				.doSelectPageInfo(new ISelect() {
					@Override
					public void doSelect() {
						nobPlanService.query(param.getMap());
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
	public JsonMsgUtil edit(NobPlan nobPlan) {
		LoginUser loginUser = UserUtil.getLoginUser();
		return nobPlanService.edit(nobPlan, loginUser);
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
		return nobPlanService.findById(id);
	}
	/**
	 * 
	 * @Description: 查询本项目下的  用户列表
	 * @author weichengz
	 * @date 2019年2月17日 下午11:13:03
	 */
	@ResponseBody
	@RequestMapping(value = "/queryLoginUser", method = RequestMethod.POST)
	public JsonMsgUtil queryLoginUser() {
		LoginUser loginUser = UserUtil.getLoginUser();
		return nobPlanService.queryLoginUser(loginUser.getProjId());
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
		return nobPlanService.delete(ids);
	}

	/**
	 * 
	 * @Description: 文件的批量上传
	 * @author weichengz
	 * @date 2019年4月22日 下午4:45:21
	 */
	@ResponseBody
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public JsonMsgUtil uploadRoadTest(@RequestParam(value = "file") MultipartFile file) {
		LoginUser loginUser = UserUtil.getLoginUser();
		return nobPlanService.upload(file, loginUser);
	}
}
