package com.neo.model;

//import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.*;
import lombok.experimental.Accessors;
import java.io.Serializable;
import static com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName(value = "users")
public class User extends Model<User> implements Serializable {
	@TableId(type = ASSIGN_ID)
	private Long id;
	//@TableField("name")
	private String name;
	//@TableField("age")
	private Integer age;
	//@TableField("email")
	private String email;
	//@TableField("address")
	private String address;
}