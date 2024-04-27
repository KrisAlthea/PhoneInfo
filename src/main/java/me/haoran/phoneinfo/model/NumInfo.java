package me.haoran.phoneinfo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;


/**
 * ClassName: NumInfo
 * Package: com.example.demo.model.domain
 * Description:
 *
 * @Author Haoran
 * @Create 4/25/2024 1:18 AM
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumInfo implements Serializable {
	@Serial
	private static final long serialVersionUID = 1407225419991674020L;

	private String City;

	private String Prov;

}
