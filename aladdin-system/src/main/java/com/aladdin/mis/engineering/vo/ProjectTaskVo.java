package com.aladdin.mis.engineering.vo;

import com.aladdin.mis.engineering.entity.ProjectTask;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import lombok.Data;

/**
 * 项目任务表应用层实体 
 * @author cles
 * @date 2022-07-05 21:58:00
*/
@Data
public class ProjectTaskVo extends ProjectTask {

}
