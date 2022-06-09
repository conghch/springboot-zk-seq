package demo.springboot.utils;


import demo.springboot.ConfigApplication;
import studio.raptor.gid.Sequencer;
import studio.raptor.gid.common.GidException;
import studio.raptor.gid.def.BreadcrumbDef;
import studio.raptor.gid.def.SequenceDef;
import studio.raptor.gid.kind.Sequencable;

import java.util.Map;

public class SeqGeneratorUtil {

    //获取序列
    public static long getSeq(String seqName){
        Sequencer sequencer = ConfigApplication.applicationContext.getBean(Sequencer.class);
        try {
            Map sequences = sequencer.getSequences();
            if (!sequences.containsKey(seqName)){
                initSeq(sequencer,seqName);
            };
            Sequencable sequencable = sequencer.get(seqName);
            return sequencable.nextId();
        } catch (Exception e) {
            throw new RuntimeException("全局序列服务异常", e);
        }
    }

    //如果序列不存在则新创建
    private static void initSeq(Sequencer sequencer, String seqName) throws GidException {
        SequenceDef seqDef = new BreadcrumbDef() {
            @Override
            public String name() {
                return seqName;
            }

            @Override
            public int cache() {
                return 10;
            }

            @Override
            public long incr() {
                return 1;
            }

            @Override
            public long start() {
                return 100000;
            }
        };
        sequencer.add(seqDef);
    }

    /**
     * 重置序列
     * @param seqName 序列名称
     * @param newStart 新的起始值
     * @throws GidException
     */
    public static void resetSeq(String seqName,Long newStart) throws GidException {
        Sequencer sequencer = ConfigApplication.applicationContext.getBean(Sequencer.class);
        Sequencable sequencable = sequencer.get(seqName);
        sequencable.reset(newStart);
    }
}
