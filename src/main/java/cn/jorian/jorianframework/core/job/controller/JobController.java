package cn.jorian.jorianframework.core.job.controller;


import cn.jorian.jorianframework.common.annotation.Log;
import cn.jorian.jorianframework.common.response.ResponseCode;
import cn.jorian.jorianframework.common.response.SystemResponse;
import cn.jorian.jorianframework.common.utils.SpringTools;
import cn.jorian.jorianframework.core.job.dto.JobAddDTO;
import cn.jorian.jorianframework.core.job.dto.JobFindDTO;
import cn.jorian.jorianframework.core.job.entity.Job;
import cn.jorian.jorianframework.core.job.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.quartz.CronExpression;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(tags = "定时任务")
@RestController
@RequestMapping("/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@Log("新增定时任务")
	@ApiOperation("添加定时任务")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public SystemResponse add(@RequestBody @Validated @ApiParam(value = "定时任务基础信息") JobAddDTO jobAddDTO) {
		jobAddDTO.setIsSysJob(false);
		jobService.saveJob(jobAddDTO);
		return new SystemResponse(ResponseCode.SUCCESS);
	}

	@Log("更新定时任务")
	@ApiOperation("更新定时任务")
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public SystemResponse update(@RequestBody @ApiParam(value = "定时任务基础信息") Job job) {
		jobService.updateJob(job);
		return new SystemResponse(ResponseCode.SUCCESS);
	}

	@Log("逻辑删除定时任务")
	@ApiOperation("删除定时任务")
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public SystemResponse delete(@PathVariable @ApiParam(value = "定时任务id") String id) throws SchedulerException{
		jobService.deleteJob(id);
		return new SystemResponse(ResponseCode.SUCCESS);
	}

	@ApiOperation("根据id获取定时任务")
	@RequestMapping(value = "/id", method = RequestMethod.GET)
	public SystemResponse getById(@PathVariable @ApiParam(value = "定时任务id") String id) {
		return new SystemResponse(ResponseCode.SUCCESS,jobService.getById(id));
	}

	@ApiOperation("定时任务列表")
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public SystemResponse list(@ApiParam("定时任务查找条件") JobFindDTO jobFindDTO) {
		return new SystemResponse(ResponseCode.SUCCESS,jobService.getList(jobFindDTO));
	}

	@ApiOperation("校验cron表达式")
	@RequestMapping(value = "/cron", method = RequestMethod.GET)
	public SystemResponse checkCron(String cron) {
		return new SystemResponse(ResponseCode.SUCCESS,CronExpression.isValidExpression(cron));
	}

	@ApiOperation("获得spring中注册的所有bean的name")
	@GetMapping("/beans")
	public SystemResponse listAllBeanName() {
		return new SystemResponse(ResponseCode.SUCCESS, SpringTools.getBeanNames());
	}
	@ApiOperation(value = "springBean的无参方法")
	@GetMapping("/beans/method/{name}")
	public SystemResponse listMethodName(@PathVariable String name) {
		return new SystemResponse(ResponseCode.SUCCESS, SpringTools.getBeansMethods(name));
	}



}
