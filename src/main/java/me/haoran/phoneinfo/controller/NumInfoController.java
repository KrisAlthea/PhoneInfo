package me.haoran.phoneinfo.controller;


import jakarta.annotation.Resource;
import me.haoran.phoneinfo.model.NumInfo;
import me.haoran.phoneinfo.service.NumInfoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: NumInfoController
 * Package: com.example.demo.controller
 * Description:
 *
 * @Author Haoran
 * @Create 4/25/2024 1:41 AM
 * @Version 1.0
 */
@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class NumInfoController {
	@Resource
	private NumInfoService numInfoService;

	@GetMapping("getPhoneInfo")
	public NumInfo getInfo (@RequestParam String phoneNumber) {
		return numInfoService.getNumInfo(phoneNumber);
	}
}
