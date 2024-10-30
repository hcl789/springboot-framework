package com.codingapi.springboot.flow.pojo;

import com.codingapi.springboot.flow.bind.BindDataSnapshot;
import com.codingapi.springboot.flow.bind.IBindData;
import com.codingapi.springboot.flow.domain.FlowNode;
import com.codingapi.springboot.flow.domain.FlowWork;
import com.codingapi.springboot.flow.domain.Opinion;
import com.codingapi.springboot.flow.record.FlowRecord;
import com.codingapi.springboot.flow.user.IFlowOperator;
import lombok.Getter;

import java.util.List;


/**
 * 流程详情的阻止对象
 */
@Getter
public class FlowDetail {

    /**
     * 当前流程
     */
    private final FlowRecord flowRecord;
    /**
     * 流程设计器
     */
    private final FlowWork flowWork;
    /**
     * 流程节点
     */
    private final FlowNode flowNode;
    /**
     * 历史流程
     */
    private final List<FlowRecord> historyRecords;
    /**
     * 绑定数据
     */
    private final IBindData bindData;
    /**
     * 全部的操作人
     */
    private final List<? extends IFlowOperator> operators;

    /**
     * 创建者
     */
    private final IFlowOperator flowCreator;

    /**
     * 创建时间
     */
    private final long flowCreateTime;

    /**
     * 流程的意见
     */
    private final List<FlowOpinion> opinions;


    public FlowDetail(FlowRecord flowRecord,
                      BindDataSnapshot snapshot,
                      FlowWork flowWork,
                      List<FlowRecord> historyRecords,
                      List<? extends IFlowOperator> operators) {
        this.operators = operators;
        this.flowRecord = flowRecord;
        this.flowWork = flowWork;
        this.bindData = snapshot.toBindData();
        this.historyRecords = historyRecords;
        this.opinions = historyRecords.stream().map(FlowOpinion::new).toList();
        this.flowCreator = operators.stream().filter(o -> o.getUserId() == flowRecord.getCreateOperatorId()).findFirst().orElse(null);
        this.flowCreateTime = flowRecord.getCreateTime();
        this.flowNode = flowWork.getNodeByCode(flowRecord.getNodeCode());
    }


    @Getter
    public final class FlowOpinion {
        private final long recordId;
        private final Opinion opinion;
        private final IFlowOperator operator;
        private final long createTime;

        public FlowOpinion(FlowRecord flowRecord) {
            this.recordId = flowRecord.getId();
            this.opinion = flowRecord.getOpinion();
            this.operator = operators.stream().filter(o -> o.getUserId() == flowRecord.getCurrentOperatorId()).findFirst().orElse(null);
            this.createTime = flowRecord.getUpdateTime();
        }
    }

}
