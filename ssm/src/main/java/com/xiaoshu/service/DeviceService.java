package com.xiaoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.DeviceVo;
import com.xiaoshu.entity.Type;
import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;



@Service
public class DeviceService {

	@Autowired
	DeviceMapper deviceMapper;
	
	@Autowired
	TypeMapper typeMapper;
	
	
	public List<DeviceVo> countDevice(){
		return deviceMapper.countDevice();
	}
	
	
	public List<Type> findType(){
		return typeMapper.selectAll();
	}
	public PageInfo<DeviceVo> findPage(DeviceVo deviceVo,Integer pageSize,Integer pageNum){
		PageHelper.startPage(pageNum, pageSize);
		List<DeviceVo> list=deviceMapper.findList(deviceVo);
		return new PageInfo<>(list);
	}
	
	public void deleteDevice(Integer id) {
		deviceMapper.deleteByPrimaryKey(id);
	}
	
	public Device findDevice(String deviceName) {
		Device device=new Device();
		device.setDeviceName(deviceName);
		return deviceMapper.selectOne(device);
	}
	public void addDevice(Device device) {
		deviceMapper.insert(device);
	}
	public void updateDevice(Device device) {
		deviceMapper.updateByPrimaryKeySelective(device);
	}
}
