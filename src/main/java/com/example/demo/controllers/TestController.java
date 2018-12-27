package com.example.demo.controllers;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.Authorization;
import io.swagger.annotations.AuthorizationScope;
import io.swagger.annotations.ExampleProperty;
import io.swagger.annotations.SwaggerDefinition;
import com.example.demo.config.ConfigManager;
import com.example.demo.helper.ResponseHelper;
import com.example.demo.models.Task_definition;
import com.example.demo.service.TestService;

import springfox.documentation.annotations.ApiIgnore;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.flywaydb.core.Flyway;

@EnableScheduling
@RestController
@RequestMapping("/v1/test")
@Api(value="v1", description=" ", tags = { "v1" },authorizations = {@Authorization(value = "Authorization",scopes = {})})
@PropertySource("classpath:application.properties")
public class TestController {

	private String AuthinticationToken = ConfigManager.AUTH_TOKEN;

	// Create the Flyway instance and point it to the database
    Flyway flyway = Flyway.configure().dataSource("jdbc:h2:file:./target/foobar", "sa", null).load();
	
	@Autowired
	TestService testService;
	
	@Autowired
	Environment environment;
	
	@RequestMapping(value = "/", method = RequestMethod.GET,headers = "Accept=application/json")
	@ResponseBody
	@ApiOperation(value = "Get Rows")
	public Object getRecords(@ApiIgnore @RequestHeader("Authorization") String authToken, @RequestParam("offset") Optional<String> offset, @RequestParam("limit") Optional<String> limit)
	{
		try {
			if (!limit.isPresent()) {
				limit = Optional.of("50");
			}
			if (!offset.isPresent()) {
				offset = Optional.of("0");
			}
			if (Integer.parseInt(limit.get()) <= 0) {
				limit = Optional.of("50");
			}
			if (Integer.parseInt(offset.get()) <= 0) {
				offset = Optional.of("0");
			}
			List<Task_definition> ListObject = testService.getAllByPage(limit, offset);
			return ResponseHelper.successTest(ListObject,testService.getCount(),HttpStatus.OK);

		}catch (Exception $e){
			return ResponseHelper.failed($e.getMessage(),HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	@ApiOperation(value = "Create a Record")
	public Object AddRecord(@ApiIgnore @RequestHeader("Authorization") String authToken, @RequestBody Task_definition input) throws Exception
	{
			try {
				return ResponseHelper.successTest(testService.post(input),1,HttpStatus.OK);
			}catch (Exception $e){
				return ResponseHelper.failed($e.getMessage(),HttpStatus.NOT_FOUND);
			}


	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT,headers = "Accept=application/json")
	@ResponseBody
	@ApiOperation(value = "Edit a Record")
	public Object EditRecord(@ApiIgnore @RequestHeader("Authorization") String authToken,@RequestBody Task_definition input, @PathVariable("id") int id) throws Exception
	{
			try {
				return ResponseHelper.successTest(testService.put(input, id),1,HttpStatus.OK);
			}catch (Exception $e){
				return ResponseHelper.failed($e.getMessage(),HttpStatus.NOT_FOUND);
			}


	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE,headers = "Accept=application/json")
	@ResponseBody
	@ApiOperation(value = "Delete a Record")
	public ResponseEntity<?> deleteRecord(@ApiIgnore @RequestHeader("Authorization") String authToken,@PathVariable("id") int id) throws Exception
	{
		try{
			return ResponseHelper.successStringMessage(testService.deleteRecord(id),HttpStatus.OK);
		}catch (Exception $e){
			return ResponseHelper.failed($e.getMessage(),HttpStatus.NOT_FOUND);
		}

	}
}



