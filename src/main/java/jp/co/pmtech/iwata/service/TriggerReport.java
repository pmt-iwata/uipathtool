package jp.co.pmtech.iwata.service;

import java.util.List;

import jp.co.pmtech.iwata.dto.UiPathTriggerDto;

public interface TriggerReport {
    
    void write(String dest, List<UiPathTriggerDto> triggerList) throws Exception;
}
