package me.haoran.phoneinfo.service;

import me.haoran.phoneinfo.model.NumInfo;

/**
 * ClassName: NumInfoService
 * Package: com.example.demo.service
 * Description:
 *
 * @Author Haoran
 * @Create 4/25/2024 1:23 AM
 * @Version 1.0
 */
public interface NumInfoService {
	NumInfo getNumInfo (String phoneNumber);
}
