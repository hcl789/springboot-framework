package com.codingapi.example.infra.convert;

import com.codingapi.example.domain.Leave;
import com.codingapi.example.infra.entity.LeaveEntity;

public class LeaveConvertor {


    public static LeaveEntity convert(Leave leave){

        if(leave==null){
            return null;
        }
        LeaveEntity leaveEntity = new LeaveEntity();
        leaveEntity.setDesc(leave.getDesc());
        leaveEntity.setDays(leave.getDays());
        leaveEntity.setUserId(leave.getUserId());
        leaveEntity.setUserName(leave.getUserName());
        return leaveEntity;

    }


    public static Leave convert(LeaveEntity leaveEntity){

        if(leaveEntity==null){
            return null;
        }
        Leave leave = new Leave();
        leave.setDesc(leaveEntity.getDesc());
        leave.setDays(leaveEntity.getDays());
        leave.setUserId(leaveEntity.getUserId());
        leave.setUserName(leaveEntity.getUserName());
        return leave;

    }
}
