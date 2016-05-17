package com.wangfj.core.constants;

/**
 * 说明:
 * 
 * @author guansq
 * @date 2012-12-10 下午02:56:48
 * @modify
 */
public class ErrorCodeConstants {
  public enum ErrorCode {

    /**
     * 错误编码规范： 长度：8位 前两位:系统 中间三位:业务 后三位:异常编码
     */
    /* 公共 100 刘海鹏 */
    UPDATE_STATUS_ERROR("00100010", "修改优惠券状态失败"), DATA_OPER_ERROR("00100006", "数据操作异常"), DOPOST_SYN_FAILED(
        "00100011", "调用SYN服务失败,下发失败"),
    /* 商品字典,非空校验 104 张学祎 */
    SUPPLYINFO_NULL("00104014", "供应商不存在"), SUPPLYINFO_STATUS_ERROR("00104015", "供应商状态不可用"), SUPPLYINFO_BUSSINESS_ERROR(
        "00104016", "供应商经营方式不一致"), SHOPPE_NULL("00104017", "专柜不存在"), SHOPPE_STATUS_ERROR(
        "00104018", "专柜状态不可用"), CATEGORY_GL_NULL("00104019", "管理分类不存在"), SEASON_NULL("00104020",
        "季节不存在"), DISCOUNTCODE_NULL("00104021", "扣率码不存在"), DISCOUNTCODE_INFO_ERROR("00104022",
        "扣率码专柜及供应商信息与录入信息不一致"), COLOR_NULL("00104023", "色系字典不存在"), BH_PARA_ERROR("00104024",
        "百货必填参数缺失"), CS_PARA_ERROR("00104025", "超市必填参数缺失"), LY_PARA_ERROR("00104026", "联营必填参数缺失"), FLY_PARA_ERROR(
        "00104027", "非联营必填参数缺失"), SHOPP_IS_EXIST("00104028", "专柜商品已存在"), BARCODE_IS_EXIST(
        "00104029", "条码在该门店下已存在"), SKU_IS_EXIST("00104030", "商品基本信息(SKU)已存在"), SHOPPEPRODUCT_SUPPLY_RELATION_ERROR(
        "00104031", "添加一品多供应商关系失败"), OPE_FAILE("00104032", "操作失败"), RELATION_IS_EXIST("00104033",
        "已存在关联数据"), DS_PARA_ERROR("00104033", "色系、色码、款号字段缺失"), BH_PARAS_ERROR("00104034",
        "百货商品_商品名,款号,色系,色码,年份,季节不能为空"), BH_PARAS_ERROR1("00104035", "百货非联营商品_进项税/销项税不能为空"), CS_PARAS_ERROR(
        "00104036", "超市商品_主属性/特性/注册商标名/销项税/进项税不能为空"), FLY_PARAS_ERROR("00104037",
        " 扣率/进价与扣率/含税进价字段不能同时为空"), PRO_ACTIVE_SID_ERROR("00104038", "活动编码不能为空"), PRO_ACTIVE_TIME_ERROR(
        "00104038", "活动编码不能为空"), PCM_SHOPPE_TYP_PRO("00104039", "专柜类型为单品专柜"), PCM_STATUS_FALSE_NULL(
        "00104040", "专柜商品不存在或禁售"), PCM_SHOPPE_TYP_ERP("00104041", "专柜类型为大码专柜"),

    /* 修改品牌 107 王选 */
    MODIFY_SHOP_BRAND_ERROR("00107032", "专柜商品修改品牌失败"),

    /*
     * 品类 109 段昭乐
     */
    CATEGORY_UPLOAD("00109004", "上传管理分类错误"), CATEGORY_ADD_ERROR("00109006", "添加失败"), CATEGORY_UPDATE_ERROR(
        "00109010", "修改失败"),

    /* 要约信息 110 段昭乐 */
    CONTRACT_UPLOAD_ERROR("00110001", "上传要约信息错误"),

    /* spu、sku、专柜商品添加 111 叶东 */
    ADD_PRODUCT_ERROR("00111002", "创建SPU失败"), UPDATE_PRODUCTCODE_ERROR("00111003", "修改SPU编码失败"), ADD_CATEGORY_GY_PRODUCT_ERROR(
        "00111006", "创建SPU与工业分类关联关系失败"), ADD_CATEGORY_TJ_PRODUCT_ERROR("00111007",
        "创建SPU与统计分类关联关系失败"), BRANDGROUP_NULL("00111008", "品牌不存在或者失效"), ADD_COlOR_ERROR("00111009",
        "创建色码字典表失败"), ADD_STAN_ERROR("00111010", "创建规格字典表失败"), ADD_PRODUCT_DETAIL_ERROR("00111011",
        "创建sku失败"), ADD_PRODUCT_DETAIL_CODE_ERROR("00111012", "创建sku编码失败"), ADD_PRODUCT_SHOPPRO_ERROR(
        "00111013", "创建专柜商品失败"), ADD_PRODUCT_SHOPPRO_CODE_ERROR("00111014", "创建专柜商品编码失败"), ADD_PRODUCT_PRICE_ERROR(
        "00111015", "创建价格失败"), ADD_PRODUCT_STAN_BARCODE_ERROR("00111016", "创建标准条码失败"), ADD_SALE_UNIT_CODE_ERROR(
        "00111017", "创建销售编码失败"), ADD_MQ_ERROR("00111018", "插入MQ记录表失败"), UPDATE_MQ_ERROR("00111019",
        "修改MQ记录表失败"),

    /* 商品 111 叶东 */
    PRO_INPUT_ERROR("00111030", "临时表插入错误"), UNSUPPORT_ACTION("00111031", "无法通过此接口修改品牌,专柜,供应商"), STOCK_INPUT_ERROR(
        "00111037", "库存写入错误"), PARAMETER_INPUT_ERROR("00111039", "产品属性写入错误"), ADD_CATE_ERROR(
        "00111042", "关联展示分类失败"),

    /* 价格 300 孔庆富 */
    ADD_CHANGE_PRICE_ERROR("00300001", "创建变价信息失败"), DEL_CHANGE_PRICE_ERROR("00300002", "删除变价信息失败"), PRICE_CHANGERECORD_ERROR(
        "00300012", "变价请求记录插入失败;"), PAYMENT_ADD_FAILED("00300020", "支付方式添加失败"), PAYMENT_STORE_ADD_FAILED(
        "00300022", "门店添加支付方式失败"),

    /* 库存管理 301 孔庆富 */
    STOCK_REDUCE_FAILED_ERROR("00301107", "减库失败"), STOCK_UNLOCK_FAILED_ERROR("00301109", "解锁失败"), STOCK_REFUND_FAILED_ERROR(
        "00301111", "还库失败"), STOCK_OPERATION_FAILED_ERROR("00301115", "操作失败"),
    /* 商品图片 302 孔庆富 */
    PICTURE_SAVE_FAILED("00302010", "图片保存失败");
    private String errorCode;
    private String memo;

    private ErrorCode() {
    };

    private ErrorCode(String errorCode, String memo) {
      this.errorCode = errorCode;
      this.memo = memo;
    }

    public String getErrorCode() {
      return errorCode;
    }

    public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
    }

    public String getMemo() {
      return memo;
    }

    public void setMemo(String memo) {
      this.memo = memo;
    }

    public static boolean vaildErrorCode(String errorCode) {
      ErrorCode[] ecs = ErrorCode.values();
      for (ErrorCode er : ecs) {
        if (er.getErrorCode().equalsIgnoreCase(errorCode)) {
          return true;
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {

  }
}
