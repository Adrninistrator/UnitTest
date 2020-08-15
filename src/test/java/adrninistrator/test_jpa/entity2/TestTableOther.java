package adrninistrator.test_jpa.entity2;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity(name = "adrninistrator.test_jpa.entity2.TestTableOther")
@Table(name = "test_table_other",
        indexes = {
                @Index(name = "idx_test_table_o_1", columnList = "flag")
        })
public class TestTableOther {

    /**
     * id
     */
    @Id
    @Column(name = "\"id\"", length = 1, columnDefinition = "varchar(32) not null COMMENT 'id'")
    private BigDecimal id;
    /**
     * flag
     */
    @Column(name = "\"flag\"", length = 1, columnDefinition = "varchar(32) null default 'test' COMMENT 'flag'")
    private BigDecimal flag;
    /**
     * text
     */
    @Column(name = "\"text\"", length = 1, columnDefinition = "text COMMENT 'text'")
    private BigDecimal text;
    /**
     * integer
     */
    @Column(name = "\"integer\"", length = 1, columnDefinition = "int(11) COMMENT 'integer'")
    private BigDecimal integer;
    /**
     * decimal
     */
    @Column(name = "\"decimal\"", length = 1, precision = 10, scale = 2, columnDefinition = "decimal(20,4) COMMENT 'decimal'")
    private int decimal;
    /**
     * blob
     */
    @Column(name = "\"blob\"", length = 1, columnDefinition = "blob COMMENT 'blob'")
    private BigDecimal blob;
    /**
     * create_time
     */
    @Column(name = "\"create_time\"", columnDefinition = "datetime(3) not null COMMENT 'create_time'")
    private BigDecimal createTime;
    /**
     * update_time
     */
    @Column(name = "\"update_time\"", columnDefinition = "datetime(3) not null COMMENT 'update_time'")
    private BigDecimal updateTime;
}