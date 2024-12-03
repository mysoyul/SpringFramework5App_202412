package myspring.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;
import myspring.user.vo.xml.UserVOXML;

@RestController
@RequestMapping("/users")
public class RestfulUserController {
	@Autowired
	private UserService userService;
	
	public RestfulUserController() {
		System.out.println(">>>>> RestfulUserController 생성자 호출됨!!!");
	}

//	@RequestMapping(value="/users",
//			                 method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping
	public List<UserVO> getUserList() {
		List<UserVO> userList = userService.getUserList();
		return userList;
	}
	
//	@RequestMapping(value="/users/{id}",
//			                    method=RequestMethod.GET,produces = { "application/json"})
	@GetMapping("/{id}")
	public UserVO getUser(@PathVariable String id) {
		UserVO user = userService.getUser(id);
		return user;
	}
		
//	@RequestMapping(value="/users",
//			                 method=RequestMethod.POST,
//			                 headers = {"Content-type=application/json"})
	@PostMapping
	public Boolean insertUser(@RequestBody UserVO user) {
		if (user != null) {
			userService.insertUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
//	@RequestMapping(value="/users",
//			                 method=RequestMethod.PUT,
//			                headers = {"Content-type=application/json"})
//	public Boolean updateUser(@RequestBody UserVO user) {
//		if (user != null) {
//			userService.updateUser(user);
//			return Boolean.TRUE;
//		} else {	
//			return Boolean.FALSE;
//		}
//	}
	
	@PatchMapping("/{userid}")
	public Boolean updateUser(@PathVariable String userid, @RequestBody UserVO userDetail) {
		UserVO user = userService.getUser(userid);
		if (user != null) {
			user.setCity(userDetail.getCity());
			userService.updateUser(user);
			return Boolean.TRUE;
		} else {	
			return Boolean.FALSE;
		}
	}
	
//	@RequestMapping(value="/users/{id}",
//			         method=RequestMethod.DELETE)
	@DeleteMapping("/{id}")
	public Boolean deleteUser(@PathVariable String id) {
		if (id != null) {
			userService.deleteUser(id);
			return Boolean.TRUE;
		} else {		
			return Boolean.FALSE;
		}
	}
	
	@RequestMapping(value="/usersXml", method=RequestMethod.GET, produces = { "application/xml"})
	public UserVOXML getUserListXml() {
		List<UserVO> list = userService.getUserList();
		UserVOXML xml = new UserVOXML("success", list);
		return xml;
	}	
}
