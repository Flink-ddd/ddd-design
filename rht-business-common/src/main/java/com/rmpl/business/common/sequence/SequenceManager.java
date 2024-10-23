package com.rmpl.business.common.sequence;

import com.rmpl.business.common.exception.RhtBusinessException;
import com.rmpl.business.common.utils.YamlConfigurerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/***
 * @author lujingbo
 * @desc PK序列号生成程序
 * @date 2022-01-19 10:17
 */
public class SequenceManager {
    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(SequenceManager.class);

    /**
     * 单例模式，单例私有静态变量
     */
    private static SequenceManager seqManager = null;

    /**
     * 服务器编号，取值范围000-999
     */
    private int serverId = 0;

    /**
     * 数据库编号，取值范围00-99
     */
    private int dbId = 0;

    /**
     * 顺序号计数器
     */
    private long counter = 0;

    /**
     * 序列号基本时间
     */
    private long baseTimeSecond = 0L;

    /**
     * 私有构造器
     */
    private SequenceManager() throws RhtBusinessException {
        init();
    }

    /**
     * 单例实例接口
     *
     * @return
     * @throws RhtBusinessException
     */
    public static SequenceManager singleton() throws RhtBusinessException {
        if (seqManager == null) {
            seqManager = new SequenceManager();
        }
        return seqManager;
    }

    /**
     * 主服务接口，生成序列号
     *
     * @return
     */
    public synchronized Long getNextSequence() {
        //01. 取系统时间（毫秒），转换成秒
        long currentTimeMillis = System.currentTimeMillis();
        long curTimeSecond = currentTimeMillis / 1000;
        synchronized (seqManager) {
            //跨时间段了！
            if (curTimeSecond > baseTimeSecond) {
                long overflow = counter / 10000;
                //顺序号溢出
                if (overflow > 0) {
                    this.baseTimeSecond += overflow;
                    counter = counter % 10000;
                    logger.info(String.format(
                            "创建序列号时顺序号溢出,最终结果：currentTimeMillis=%s, curTimeSecond=%s, this.baseTimeSecond=%s, counter=%s",
                            currentTimeMillis, curTimeSecond, this.baseTimeSecond, counter));
                } else {
                    this.baseTimeSecond = curTimeSecond;
                    counter = 0;
                }
            }
            //当前时间(10)-顺序号(4)-机器号(3)-数据库位(2)
            long sequence = this.baseTimeSecond * 10000L * 1000L * 100L; //时间
            sequence += counter * 1000L * 100L; //顺序号
            sequence += serverId * 100L; //服务器号
            sequence += dbId; //数据库位
            counter++;
            return sequence;
        }

    }

    /**
     * 初始化
     *
     * @throws RhtBusinessException
     */
    private void init() throws RhtBusinessException {
        String sequenceServerId = YamlConfigurerUtil.getStrYmlVal("sequenceServerId");
        //配置参数1：服务器编号，来源于appcontext配置文件
        if (sequenceServerId == null) {
            throw new RhtBusinessException("服务器编号api.top.serverId不能为空！");
        }
        try {
            serverId = Integer.parseInt(sequenceServerId.trim());
        } catch (NumberFormatException e) {
            throw new RhtBusinessException("服务器编号api.top.serverId不正确！");
        }

        //配置参数2：数据库位置，来源于appcontext配置文件
        String sequencedbId = YamlConfigurerUtil.getStrYmlVal("sequencedbId");

        if (sequencedbId == null) {
            throw new RhtBusinessException("数据库编号api.top.serverdbId不能为空！");
        }
        try {
            dbId = Integer.parseInt(sequencedbId.trim());
        } catch (NumberFormatException e) {
            throw new RhtBusinessException("数据库编号api.top.serverdbId不正确！");
        }
    }

}
