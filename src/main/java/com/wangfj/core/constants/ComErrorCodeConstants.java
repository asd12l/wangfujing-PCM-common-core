/**
 * @Probject Name: 00_product_common
 * @Path: com.bailian.core.constantsComErrorCodeConstants.java
 * @Create By wangfei
 * @Create In 2014年9月29日 上午11:07:39
 * TODO
 */
package com.wangfj.core.constants;

import java.util.HashMap;
import java.util.Map;

import com.wangfj.core.utils.PropertyUtil;

/**
 * 通用系统异常信息
 * 
 * @Class Name ComErrorCodeConstants
 * @Author wangfei
 * @Create In 2014年9月29日
 */
public class ComErrorCodeConstants {
  public enum ErrorCode {
    /**
     * 错误编码规范： 长度：8位 前两位:系统 中间三位:业务 后三位:异常编码
     */
    /* 公共 100 刘海鹏 */
    UPDATE_HAVE_ERROR("00100001", "数据已存在"), SYSTEM_SUCCESS("00100002", "succes"), SYSTEM_ERROR(
        "00100003", "网络连接异常!"), PARA_NORULE_ERROR("00100004", "请求参数格式不符合规则"), VALIDATE_ERROR(
        "00100005", "校验有误"), DATA_OPER_ERROR("00100006", "数据操作异常"), APPLICATION_OPER_ERROR(
        "00100007", "系统业务异常"), ACCOUNT_EXIST_ERROR("00100008", "账号信息存在异常"), DATA_EMPTY_ERROR(
        "00100009", "查询结果为空"), UPDATE_STATUS_ERROR("00100010", "修改优惠券状态失败"), DOPOST_SYN_FAILED(
        "00100011", "调用SYN服务失败,下发失败"), PARA_EMPTY_ERROR("00100012", "请求参数不能为空"), PARA_LIMITSTART_ERROR(
        "00100013", "分页起始位置不能为空"), PARA_LIMIT_ERROR("00100014", "分页请求记录数不能为空"), ACTIONCODE_IS_EMPTY(
        "00100015", "actionCode不能为空"),

    /* 组织机构 101 刘海鹏 */
    ORGANIZATION_IS_NOT_ONLY("00101001", "组织机构数据不唯一"), ORGANIZATION_IS_EXIST("00101002", "该组织机构不存在"), ORGANIZATION_NAME_IS_ERROR(
        "00101003", "组织机构名称含有英文"), ORGANIZATION_IS_ERROR("00101004", "组织机构编码含有中文"), ORGANIZATION_TYPE_ERROR(
        "00101005", "组织机构类型出错"), SHOP_NULL("00101006", "门店不存在或门店不可用"), ORGANIZATON_RELATED_IS_ERROR(
        "00101007", "组织机构关联数据不存在"), CITY_CODE_NOT_ONLY("00101008", "该城市编码已存在"), CITY_NAME_NOT_ONLY(
        "00101009", "该城市名称已存在"), GROUP_CODE_NOT_ONLY("00101010", "该集团编码已存在"), GROUP_NAME_NOT_ONLY(
        "00101011", "该集团名称已存在"), AREA_CODE_NOT_ONLY("00101012", "该大区编码已存在"), AREA_NAME_NOT_ONLY(
        "00101013", "该大区名称已存在"), STORE_CODE_NOT_ONLY("00101014", "该门店编码已存在"), STORE_NAME_NOT_ONLY(
        "00101015", "该门店名称已存在"), ORGANIZATON_TYPE_IS_NULL("00101016",
        "组织机构导入终端--由主数据获取组织机构信息--传入的type不能为空"), ORGANIZATION_CODE_EXISTENCE("00101017", "组织机构编码已存在"), ORGANIZATION_NAME_EXISTENCE(
        "00101018", "组织机构名称已存在"), ERP_PRODUCT_INFO_NO_EXIST("00101019", "大码商品不存在"), ORGANIZATION_SHOPANDCOUNTER_IS_NULL(
        "00101020", "所传专柜与门店不对应"),

    /* 楼层信息 102 刘海鹏 */
    FLOOR_HAVE_ERROR("00102001", "楼层数据已存在"), FLOOR_IS_NOT("00102002", "楼层数据不存在"), FLOOR_SHOP_NOT_EXIST(
        "00102003", "不存在楼层的门店sid"), FLOOR_PAGE_ERROR("00102004", "楼层查询传入数字有误"), FLOOR_CODE_NOT_ONLY(
        "00102005", "楼层编码已存在"), FLOOR_NAME_NOT_ONLY("00102006", "楼层名称已存在"), FLOOR_BY_SHOPSID_NULL(
        "00102007", "楼层的门店sid参数为空"), FLOOR_SELECT_FM_NULL("00102008", "门店sid数据错误"), FLOOR_SHOP_NOT_ERROR(
        "00102009", "该门店不存在"), FLOOR_SHOP_NOT_RELATIVE("00102010", "根据所传参数没有找到对应的关联表属性值"), FLOOR_NAME_IS_ERROR(
        "00102011", "楼层名称含有英文"), FLOOR_IS_ERROR("00102012", "楼层编码含有中文"),
    /* 专柜 103 张学祎 */
    SHOPPE_SHOP_NOT_EXIST("00103001", "不存在该专柜的所属门店"), SHOPPE_OPER_ERROR("00103002", "专柜添加名称已存在"), SHOPPE_PAGE_ERROR(
        "00103003", "专柜分页查询传入数字有误"), SHOPPE_IS_NOT("00103004", "专柜不在该门店或门店还未有专柜"), SHOPPE_STATUS_IS_ERROR(
        "00103005", "专柜的目前状态错误"), SHOPPE_STATUS_UPDATE_ERROR("00103006", "专柜撤柜状态下不能恢复正常"), SHOPPE_NAME_IS_ERROR(
        "00103007", "专柜名称含有英文"), SHOPPE_IS_ERROR("00103008", "专柜编码含有中文"), SHOPPE_NAME_EXISTENCE(
        "00103009", "专柜名称已存在"), SHOPPE_EXIST("00103010", "专柜已存在"),
    /* 专柜导入终端--由主数据获取专柜信息 wangxuan */
    SHOPPE_STORECODE_IS_NULL("00103009", "专柜导入终端--由主数据获取专柜信息--传入的storeCode不能为空"),

    /* 字典表 104 张学祎 */
    DICT_CODE_NOT_ONLY("00104010", "字典编码已存在"), DICT_NAME_NOT_ONLY("00104011", "字典名称已存在"), DICT_IS_ERROR(
        "00104012", "根据sid没有找到该字典"), DICT_VALUES_IS_ERROR("00104013", "未传入字典参数"),
    /* 商品字典,非空校验 104 张学祎 */
    SUPPLYINFO_NULL("00104014", "供应商不存在"), SUPPLYINFO_STATUS_ERROR("00104015", "供应商状态不可用"), SUPPLYINFO_BUSSINESS_ERROR(
        "00104016", "所传商品经营方式与供应商经营方式不一致"), SHOPPE_NULL("00104017", "专柜不存在"), SHOPPE_STATUS_ERROR(
        "00104018", "专柜状态不可用"), CATEGORY_GL_NULL("00104019", "管理分类不存在"), SEASON_NULL("00104020",
        "季节不存在"), DISCOUNTCODE_NULL("00104021", "扣率码不存在"), DISCOUNTCODE_INFO_ERROR("00104022",
        "扣率码所在专柜及对应供应商信息与上传信息不一致"), COLOR_NULL("00104023", "色系字典不存在"), BH_PARA_ERROR("00104024",
        "百货必填参数缺失"), CS_PARA_ERROR("00104025", "超市必填参数缺失"), LY_PARA_ERROR("00104026", "联营必填参数缺失"), FLY_PARA_ERROR(
        "00104027", "非联营必填参数缺失"), SHOPP_IS_EXIST("00104028", "专柜商品已存在"), BARCODE_IS_EXIST(
        "00104029", "条码在该门店下已存在"), SKU_IS_EXIST("00104030", "商品基本信息(SKU)已存在"), SHOPPEPRODUCT_SUPPLY_RELATION_ERROR(
        "00104031", "添加一品多供应商关系失败"), OPE_FAILE("00104032", "操作失败"), RELATION_IS_EXIST("00104033",
        "已存在关联数据"), DS_PARA_ERROR("00104033", "电商商品必填参数缺失"), BH_PARAS_ERROR("00104034",
        "百货商品必填字段缺失"), BH_PARAS_ERROR1("00104035", "百货非联营商品_进项税/销项税不能为空"), CS_PARAS_ERROR(
        "00104036", "超市商品必填参数缺失"), FLY_PARAS_ERROR("00104037", " 扣率/进价与扣率/含税进价字段不能同时为空"), PRO_ACTIVE_SID_ERROR(
        "00104038", "活动编码不能为空"), PRO_ACTIVE_TIME_ERROR("00104038", "活动编码不能为空"), PCM_SHOPPE_TYP_PRO(
        "00104039", "专柜类型为单品专柜"), PCM_STATUS_FALSE_NULL("00104040", "专柜商品不存在或禁售"), PCM_SHOPPE_TYP_ERP(
        "00104041", "专柜类型为大码专柜"), DISCOUNTCODE_INFO_ERROR_COUNTERCODE("00104042",
        "扣率码所在专柜与上传专柜信息不一致"), DISCOUNTCODE_INFO_ERROR_SUPPLIER("00104043", "扣率码对应供应商与上传供应商信息不一致"), SKU_IS_EXIST1(
        "00104044", "所传色系已对应不同色码，请确认所传商品信息的色系与色码关系正确性"), BARCODE_IS_NO_EXIST("00104045", "条码不存在"),
         SHOPP_NOT_EXIST("00104046", "专柜商品不存在，无法修改信息"),
    /* 销售渠道 105 张学祎 */
    CHANNEL_EXIST("00105034", "销售渠道名称或编码已经存在"), CHANNEL_SID_IS_NULL("00105035", "销售渠道sid不能为空"), CHANNEL_CHANNELNAME_EXIST(
        "00105036", "销售渠道名称已经存在"), CHANNEL_CHANNELCODE_EXIST("00105037", "销售渠道编码已经存在"),

    /* 品牌 107 王选 */
    BRANDGROUP_NOT_EXIST("00107001", "集团品牌不存在"), BRANDGROUP_IS_NOT("00107002", "修改集团品牌时修改的不是集团品牌"), BRANDGROUP_EXIST(
        "00107003", "集团品牌的名称或者编码已经存在"), BRANDGROUP_BRANDNAEM_EXIST("00107004", "集团品牌名称已经存在"), BRANDGROUP_BRANDSID_EXIST(
        "00107005", "集团品牌编码已经存在"), BRANDGROUP_BRANDNAEM_MODIFY("00107006", "不许修改集团品牌名称"), BRANDGROUP_BRANDSID_MODIFY(
        "00107007", "不许修改集团品牌编码"), BRANDGROUP_SID_IS_NULL("00107008", "没有传入集团品牌的sid"), BRANDGROUP_BRANDNAEM_IS_NULL(
        "00107009", "集团品牌名称不能为空"), BRANDGROUP_BRANDSID_IS_NULL("00107010", "集团品牌编码不能为空"), BRANDGROUP_BRANDNAMESECOND_EXIST(
        "00107011", "集团品牌中文名称已经存在"), BRANDGROUP_BRANDNAMEEN_EXIST("00107012", "集团品牌英文名称已经存在"),

    /* 门店品牌 107 王选 */
    BRAND_EXIST("00107011", "门店品牌已存在"), BRAND_NOT_EXIST("00107012", "门店品牌不存在"), BRAND_BRANDNAEM_IS_NULL(
        "00107013", "门店品牌名称不能为空"), BRAND_BRANDNAEM_EXIST("00107014", "门店品牌名称已经存在"), BRAND_BRANDSID_IS_NULL(
        "00107015", "门店品牌编码不能为空"), BRAND_BRANDSID_EXIST("00107016", "门店品牌编码已经存在"), BRAND_BRANDNAEM_MODIFY(
        "00107017", "不许修改门店品牌名称"), BRAND_BRANDSID_MODIFY("00107018", "不许修改门店品牌编码"), BRAND_SID_IS_NULL(
        "00107019", "没有传入门店品牌的sid"), BRAND_SHOPTYPE_IS_NULL("00107020", "没有传入门店品牌的shopType"), BRAND_SHOP_RELATION_EXISTENCE(
        "00107021", "门店与门店品牌的关系已存在"), BRAND_SHOP_RELATION_IS_NULL("00107022", "门店与门店品牌的关系不存在"),
    /* 商品导入终端--由主数据获取品牌信息 107 王选 */
    BRAND_STORETYPE_IS_NULL("00107022", "商品导入终端--由主数据获取品牌信息没有传入storeType"),
    /* 搜索查询门店品牌信息 107 王选 */
    BRAND_STORECODE_IS_NULL("00107023", "搜索查询门店品牌信息没有传入storeCode"), BRAND_STOREBRANDCODE_IS_NULL(
        "00107023", "搜索查询门店品牌信息没有传入storeBrandCode"),
    /* 门店品牌与集团品牌的关系 107 王选 */
    BRANDRELATION_NOT_EXIST("00107024", "门店品牌与集团品牌的关系不存在"), BRANDRELATION_PARENTSID_IS_NULL(
        "00107025", "传入的parentSid即集团品牌的sid不能为空"), BRANDRELATION_BRAND_HAS_SHOPPEPRODUCT("00107026",
        "该门店品牌下存在专柜商品，不让修改关系"),

    /* 修改品牌 107 */
    SHOPPEPRODUCT_NULL("00107046", "找不到对应的专柜商品"), NEW_SHOPBRAND_NULL("00107047", "新门店品牌不存在"), NEW_SHOPBRAND_INVALID(
        "00107048", "新门店品牌已失效"), NEW_SHOPBRAND_SAME("00107029", "新更换品牌与原品牌不能相同"), BRANDBROUP_NULL(
        "00107050", "集团品牌不存在"), BRANDBROUP_INVALID("00107051", "集团品牌已失效"), MODIFY_SHOP_BRAND_ERROR(
        "00107052", "专柜商品修改品牌失败"), CHECK_SHOPPE_PRODUCT("00107053", "校验专柜商品失败"), SKU_EXIST_SHOPPE_PRODUCT(
        "00107054", "新品牌下存在相同的专柜商品，不允许更换"),
    /* 搜索查询商品信息 */
    SKU_INFO_NO_EXIST("00107055", "商品信息不存在"), SPU_INFO_NO_EXIST("00107056", "产品信息不存在"), PRO_INFO_NO_EXIST(
        "00107057", "专柜商品信息不存在"), PRO_YE_INFO_NO_EXIST("00107057", "单品信息不存在"),
    /* 搜索线上查询商品信息 */
    SEARCH_ONLINE_PRO_NULL("00107058", "专柜商品信息为空"), SEARCH_ONLINE_SKU_NULL("00107059", "商品信息为空"), SEARCH_ONLINE_SPU_NULL(
        "00107060", "产品信息为空"), SEARCH_ONLINE_CATEGORY_ERROR("00107061", "无效分类编码(不是展示分类或分类不可用)"),

    /* 供应商 108 王选 */
    SUPPLYINFO_SID_IS_NULL("00108001", "供应商的sid不能为空"), SUPPLYINFO_STATUS_IS_NULL("00108002",
        "供应商的status不能为空"), SUPPLYINFO_NOT_EXISTENCE("00108003", "供应商不存在"),

    /* 一品多供应商上传 108 王选 */
    PCMSHOPPEPRODUCTSUPPLY_STORECODE_IS_NULL("00108004", "一品多供应商上传时storeCode不能为空"), PCMSHOPPEPRODUCTSUPPLY_SUPPLIERCODE_IS_NULL(
        "00108005", "一品多供应商上传时supplierCode不能为空"), PCMSHOPPEPRODUCTSUPPLY_SUPPLIERPRODUCTCODE_IS_NULL(
        "00108006", "一品多供应商上传时supplierProductCode不能为空"), PCMSHOPPEPRODUCTSUPPLY_PRODUCTCODE_IS_NULL(
        "00108007", "一品多供应商上传时productCode不能为空"), PCMSHOPPEPRODUCTSUPPLY_ACTIONCODE_IS_NULL(
        "00108008", "一品多供应商上传时ACTION_CODE不能为空"), PCMSHOPPEPRODUCTSUPPLY_RELATION_EXISTENCE(
        "00108009", "一品多商的关系已经存在"),

    /*
     * 品类 109 段昭乐
     */
    CATEGORY_NOT_EXIST("00109001", "品类信息查询数据为空"), CATEGORY_SUPERIOR_NOT_EXIST("00109002",
        "该工业分类没有对应的上级分类，需先添加上级分类"), CATEGORY_EXIST("00109003", "品类信息查询数据为空"), CATEGORY_UPLOAD(
        "00109004", "上传管理分类错误"), CATEGORY_NO_STATUS("00109005", "上级分类状态为不可用"), CATEGORY_ADD_ERROR(
        "00109006", "添加失败"), CATEGORY_IS_HAVA("00109007", "该分类已经存在"), CATEGORY_CATEGORYSID_HAVA(
        "00109008", "该分类编码已经存在"), CATEGORY_ONE("00109009", "只能有一套有效的工业分类或统计分类"), CATEGORY_UPDATE_ERROR(
        "00109010", "修改失败"), PROP_VALUE_NULL("00109015", "查询属性及属性值为空"), ROOT_IS_NOT_NULL(
        "00109016", "添加或修改时根节点不能为空"), CATENAME_IS_EXIST("00109017", "此分类名已存在"), PROP_IS_EXIST(
        "00109018", "属性名在该渠道下已存在"), PROP_VALUE_IS_EXIST("00109019", "属性值在该属性下已存在"), CATE_CODE_LENGTH_ERROR(
        "00109020", "手工录入编码长度错误"), CATE_CODE_IS_EXIST("00109021", "手工录入编码已存在"), PARENT_CODE_IS_EXIST(
        "00109022", "上级手工录入编码为空,请先修改上级编码"), CATE_NOT_IS_EXIST("00109023", "该分类不存在"),

    /* 修改分类 109 段昭乐 */
    NEW_PRODUCT_CATEGORY_NO_EXIST("00109011", "待更换的工业分类不存在"), NEW_PRODUCT_NO_EXIST("00109012",
        "产品不存在"), NEW_STAT_CATEGORY_NO_EXIST("00109013", "待更换的统计分类不存在"), NEW_MANAGER_CATEGORY_NO_EXIST(
        "00109014", "待更换的管理分类不存在"), BRAND_CATE_NO_EXIST("00109015", "品牌或分类不存在"),

    /* 要约信息 110 段昭乐 */
    CONTRACT_UPLOAD_ERROR("00110001", "上传要约信息错误"), CONTRACT_IS_EXIST("00110002", "合同号已存在"), CONTRACT_VALID_ERROR(
        "00110003", "合同信息校验有误"), CONTRACT_IS_NULL("00110004", "合同不存在"), CONTRACT_RESULT_NULL_ERROR(
        "00110005", "未查询到对应电商合同"), CONTRACT_UPDATE_ERROR("00110006", "修改合同信息失败"), CONTRACT_MANGERTYPE_ERROR(
        "00110007", "要约与供应商经营方式不一致"),CONTRACT_SUPPLYINFO_NULL("00110008", "供应商不存在"),CONTRACT_CATEGORY_GL_NULL("00110008", "管理分类不存在"),

    /* spu、sku、专柜商品添加 111 叶东 */
    ADD_PRODUCT_SUCCESS("00111001", "添加产品成功"), ADD_PRODUCT_ERROR("00111002", "创建SPU失败"), UPDATE_PRODUCTCODE_ERROR(
        "00111003", "修改SPU编码失败"), CATEGORY_GY_NULL("00111004", "工业分类不存在"), CATEGORY_TJ_NULL(
        "00111005", "统计分类不存在"), ADD_CATEGORY_GY_PRODUCT_ERROR("00111006", "创建SPU与工业分类关联关系失败"), ADD_CATEGORY_TJ_PRODUCT_ERROR(
        "00111007", "创建SPU与统计分类关联关系失败"), BRANDGROUP_NULL("00111008", "品牌不存在或者失效"), ADD_COlOR_ERROR(
        "00111009", "创建色码字典表失败"), ADD_STAN_ERROR("00111010", "创建规格字典表失败"), ADD_PRODUCT_DETAIL_ERROR(
        "00111011", "创建sku失败"), ADD_PRODUCT_DETAIL_CODE_ERROR("00111012", "创建sku编码失败"), ADD_PRODUCT_SHOPPRO_ERROR(
        "00111013", "创建专柜商品失败"), ADD_PRODUCT_SHOPPRO_CODE_ERROR("00111014", "创建专柜商品编码失败"), ADD_PRODUCT_PRICE_ERROR(
        "00111015", "创建价格失败"), ADD_PRODUCT_STAN_BARCODE_ERROR("00111016", "创建标准条码失败"), ADD_SALE_UNIT_CODE_ERROR(
        "00111017", "创建销售编码失败"), ADD_MQ_ERROR("00111018", "插入MQ记录表失败"), UPDATE_MQ_ERROR("00111019",
        "修改MQ记录表失败"), ADD_PRODUCT_SUPPLY_SHOPPE_ERROR("00111020", "无对应供应商与专柜关系"),

    /* 修改色码（特性）/尺寸码（规格）111 叶东 */
    NEW_SHOPPEPRODUCT_EXIST("00111020", "新专柜商品已存在不可更换"), NEW_SKU_EXIST("00111021", "新的SKU已存在"), OLD_SKU_NO_EXIST(
        "00111022", "找不到对应的SKU"),

    /* 修改扣率码 111 叶东 */
    NEW_ERP_NO_EXIST("00111023", "新扣率码不存在"), NEW_SUPPLY_STATUS_ERROR("00111024",
        "新扣率供应商存在错误，不可更换（供应商不存在/供应商状态为停售等）"),

    /* 换专柜 111 叶东 */
    NEW_SHOPPE_NO_EXIST("00111025", "新专柜不存在"), OLD_SHOPPE_NO_INFO("00111026", "旧专柜的信息有误"), NEW_OLD_SHOPPE_TYPE(
        "00111027", "新旧专柜类型不一致"), NEW_OLD_BUSINESS_TYPE("00111028", "新旧经营方式不一致"), STAN_NULL(
        "00111029", "找不到对应的尺码"),

    /* 商品 111 叶东 */
    UNSUPPORT_ACTIONCODE("00111038", "不支持的操作类型(ActionCode)"), PRO_INPUT_ERROR("00111030", "临时表插入错误"), UNSUPPORT_ACTION(
        "00111031", "无法通过此接口修改品牌,专柜,供应商"), PRODUCT_NULL("00111032", "商品不存在"), XGLB_ERROR(
        "00111033", "单据类别(xglb字段)错误"), DATE_ERROR("00111034", "不在生效日期范围"), SUPPLY_NOSTORE(
        "00111035", "无法单独按照供应商编码查询,请传入门店编码"), BRAND_NOSTORE("00111036",
        "无法单独使用门店品牌编码进行查询,请传入门店编码,或专柜编码作为参数"), STOCK_INPUT_ERROR("00111037", "库存写入错误"), PARAMETER_INPUT_ERROR(
        "00111039", "产品属性写入错误"), PRODUCT_IS_NULL("00111040", "根据产品编码,色系未找到商品信息"), PACKDESC_IS_EXIST(
        "00111041", "已存在精包装描述"), ADD_CATE_ERROR("00111042", "关联展示分类失败"), PRO_SKU_STUATS("00111044",
        "商品启用/停用失败"), PRO_PHOTO_STUATS_ERROR("00111045", "未拍照编辑"), INVENTORY_MISS("00111046",
        "未找到库存信息"), INVENTORY_SHORT("00111047", "库存不足"), NOT_SAP_PRODUCT("00111048", "所传商品编码不是电商商品"), CONTRACT_PRODUCT_ERROR(
        "00111049", "原系统商品编码与专柜商品编码不对应"), PRO_PARA_NORULE_ERROR("00111050", "商品编码、专柜商品编码、要约号不能为空"), SAPERP_PCM_ERROR_SUPPLIERCODE(
        "00111051", "供应商编码不能为空"), SAPERP_PCM_ERROR_COUNTERCODE("00111052", "专柜编码不能为空"), SAPERP_PCM_ERROR_OPERATEMODE(
        "00111053", "经营方式不能为空"), SAPERP_PCM_ERROR_MARKETPRICE("00111054", "吊牌价参数不能为空"), SAPERP_PCM_ERROR_TAX(
        "00111055", "进项税、销项税、消费税参数不符合规则或为空"), SAPERP_PCM_ERROR_CONTRACTLOG("00111056",
        "合同经营方式与商品经营方式不一致"), SAPERP_PCM_ERROR_BRANDCODE("00111057", "品牌编码只能为数字"), SAPERP_PCM_ERROR_UNITCODE(
        "00111058", "销售单位不能为空"), SAPERP_PCM_ERROR_SIZECODE("00111059", "规格/尺码不能为空"), SAPERP_PCM_ERROR_MANAGECATEGORY(
        "00111060", "品牌专柜(管理分类)不能为空"), SAPERP_PCM_ERROR_OFFERNUMBER("00111061", "要约号参数不能空"), SAPERP_PCM_ERROR_RATEPRICE(
        "00111062", "扣率/进价/含税进价参数只能为整数或小数"), SAPERP_PCM_ERROR_DISCOUNTLIMIT("00111063",
        "折扣底限参数不能为空"), SAPERP_PCM_ERROR_ORIGIN("00111064", "产地参数不能为空"), SAPERP_PCM_ERROR_PRODCATEGORYCODE(
        "00111065", "末级工业分类编码不能为空"), SAPERP_PCM_ERROR_TYPE("00111066", "业态类型标识参数不能为空"), SAPERP_PCM_ERROR_INVENTORY(
        "00111067", "期初库存参数不能为空"), SAPERP_PCM_ERROR_KUANCODE("00111068", "款号参数不能为空"), PRO_ZS_CATEGORY_NULL(
        "00111069", "展示分类不能为空"), PRO_PRIMARY_URL_NULL("00111070", "主图不能为空"), PRO_MODELNUM_NULL(
        "00111077", "电商联营时货号不能为空"), PRO_MODELNUM1_NULL("00111078", "百货联营时货号不能为空"), PRO_ACTIVE_BIT(
        "00111079", "商品禁用，请先启用商品"), PRO_DESC_EXISTENCE("00111079", "商品描述已经存在"), PRO_SHOPPEPROCODE_ISNULL(
        "00111080", "专柜商品编码不能为空"), PRO_SKUCODE_ISNULL("00111081", "SKU编码不可为空"), PRO_MODELNUM_ISNULL(
        "00111082", "货号不可为空"), PRO_SUP_PROTYPE_ISNULL("00111083", "商品类别不能为空"), PRO_SUP_BARCODE_ISNULL(
        "00111084", "条码不存在"), PRO_BARCODE_PROCODE_ERROR("00111085", "所传条码与专柜商品编码不一致"), SAPERP_PCM_ERROR_INPUTTAX(
        "00111086", "进项税参数只能为整数数字或小数数字"), SAPERP_PCM_ERROR_OUTPUTTAX("00111087",
        "销项税参数只能为整数数字或小数数字"), SAPERP_PCM_ERROR_SALESTAX("00111088", "消费税参数只能为整数数字或小数数字"), SAPERP_PCM_ERROR_PROCUREMEN(
        "00111089", "采购人员编号参数不能为空"), SAPERP_PCM_ERROR_ENTRY("00111090", "录入人员编号参数不能为空"), SAPERP_PCM_ERROR_SALESPRICE(
        "00111091", "零售价不符合规则"), SAPERP_PCM_ERROR_STOCK_MODE("00111092", "库存方式不能为空"), SAPERP_PCM_ERROR_BARCODE_TYPE(
        "00111093", "供应商条码类型编码应为1"), SAPERP_PCM_ERROR_KUANCODE1("00111094", "款号参数不能包含汉字"), SAPERP_PCM_ERROR_SUPPLIERCODE1(
        "00111095", "供应商编码只能包含大小写字母、数字及下划线"), SAPERP_PCM_ERROR_COUNTERCODE1("00111096",
        "专柜编码只能包含大小写字母、数字及下划线"), SAPERP_PCM_ERROR_OPERATEMODE1("00111097",
        "经营方式应为0-4的数字(0经销1代销2联营3平台服务4租赁)"), SAPERP_PCM_ERROR_MANAGECATEGORY1("00111098",
        "品牌专柜(管理分类)编码只能为数字"), SAPERP_PCM_ERROR_PRODCATEGORYCODE1("00111099", "末级工业分类编码只能为数字"), SAPERP_PCM_ERROR_STATCATEGORYCODE(
        "00111100", "末级统计分类编码不能为空"), SAPERP_PCM_ERROR_STATCATEGORYCODE1("00111101", "末级统计分类编码只能为数字"), SAPERP_PCM_ERROR_MARKETPRICE1(
        "00111102", "吊牌价参数只能为整数数字或小数数字"), SUPPLIER_PCM_SALEPRICE_ISNULL("00111103", "零售价参数不能为空"), SUPPLIER_PCM_SALEPRICE_ERROR(
        "00111104", "零售价参数只能为整数数字或小数数字"), SAPERP_PCM_ERROR_UPDATESHOPPRODUCT("00111105", "修改专柜商品失败"), SAPERP_PCM_ERROR_BRANDCODE1(
        "00111106", "品牌编码不能为空"), SAPERP_PCM_ERROR_TYPE1("00111107", "业态类型标识参数应为数字[0.百货1.超市2.电商]"), SAPERP_PCM_ERROR_INVENTORY1(
        "00111108", "期初库存参数只能为数字"), PIS_PCM_TYPE_ISERROR("00111109", "业态应为数字[0.百货1.超市]"),SAPERP_PCM_ERROR_BASEUNITCODE(
        "00111110", "基本计量单位不能为空"),SAPERP_PCM_ERROR_SAPPROTYPE("00111111","商品类型不能为空"),SAPERP_PCM_ERROR_SAPPRODESC("00111112","商品名称不能为空"),
        SAPERP_PCM_ERROR_SAPSTANDARDBARCODE("00111113","供应商条码/国标码不能为空"),SAPERP_PCM_ERROR_COLORCODE("00111114","色码不能为空"),SAPERP_PCM_ERROR_ZZCOLORCODE("00111115","特性颜色码不能为空"),
        SAPERP_PCM_ERROR_ZZSIZECODE("00111116","特性尺寸码不能为空"),SAPERP_PCM_ERROR_ORIGINCOUNTRY("00111117","原产国不能为空"),SAPERP_PCM_ERROR_FIELD("00111118","统比销不能为空"),SAPERP_PCM_ERROR_ISCOD("00111119","货到付款参数不能为空"),
        SAPERP_PCM_ERROR_ISORIGINPACKAGE("00111120","是否原厂包装字段不能为空"),SAPERP_PCM_ERROR_SHOPERROR("00111121","未查询到对应专柜,请确认供应商与门店关系!"),SAPERP_PRODUCT_SUPPLY_EXIST("00111122","该专柜商品已存在对应供应商"),
    /* 行政区域 112 王选 */
    REGION_NAME_EXIST("00112000", "行政区域名称已存在！"), REGION_CODE_EXIST("00112001", "邮编已存在！"), REGION_INNER_CODE_EXIST(
        "00112002", "行政区域编码已存在！"),

    /* 商品上下架库存阀值管理 113 */
    PRODUCTONLINELIMIT_EXISTENCE("00113000", "商品上下架库存阀值已存在"), PRODUCTONLINELIMIT_BRANDSID_IS_NULL(
        "00113001", "商品上下架库存阀值时品牌的sid为空"),

    /* 价格 300 孔庆富 */
    ADD_CHANGE_PRICE_ERROR("00300001", "创建变价信息失败"), DEL_CHANGE_PRICE_ERROR("00300002", "删除变价信息失败"), PRICE_THRESHOLD_ERROR(
        "00300003", "变价之后价格超过了价格阀值,请核对变价信息"), PRICE_REQUEST_VALID("00300000", "变价请求验证"), PRICE_SHOPPEPRO_NOT_EXIST(
        "00300004", "专柜商品不存在价格信息"), PRICE_SUPPLIERPRODCODE_IS_NULL("00300005", "专柜商品编码不能为空;"), PRICE_STORECODE_IS_NULL(
        "00300006", "门店编码不能为空;"), PRICE_ZSPRICE_ERROR("00300007", "售价信息无效;"), PRICE_WAERS_IS_NULL(
        "00300008", "货币单位不能为空;"), PRICE_BDATE_ERROR("00300009", "开始日期无效;"), PRICE_EDATEE_ERROR(
        "00300010", "结束日期无效;"), PRICE_CHANGECODE_IS_NULL("00300011", "变价号不能为空;"), PRICE_CHANGERECORD_ERROR(
        "00300012", "变价请求记录插入失败;"), PRICE_MATNR_ERROR("00300013", "商品编码不能为空;"), PRICE_IMPORT_ERROR(
        "00300014", "变价请求记录超出200条;"), PRICE_SALEPRICETYPE_ERROR("00300015", "商品降价方式无效;"), PRICE_SALEPRICEVALUE_ERROR(
        "00300016", "商品降价力度无效;"), PRICE_BATCHFILTER_ERROR("00300017", "至少提供一个批量变价筛选条件;"), PAYMENT_PAYCODE_EXISTS(
        "00300018", "支付方式编码已存在"), PAYMENT_PAYNAME_EXISTS("00300019", "支付方式名称已存在"), PAYMENT_ADD_FAILED(
        "00300020", "支付方式添加失败"), PAYMENT_ADD_SUCCEED("00300021", "支付方式添加成功"), PAYMENT_STORE_ADD_FAILED(
        "00300022", "门店添加支付方式失败"), CALLBACK_PRICE_PIS_FAILED("00300023", "回传数据给导入终端失败"), PRICE_ERPPROCODE_NOT_EXISTS(
        "00300024", "ERP商品编码不存在"), PRICE_EFUTURE_SEQ_FAILED("00300025", "促销中心变价生成变价号失败"), PRICE_TIME_SEQ_FAILED(
        "00300026", "起始时间小于结束时间，请确认!"), PRICE_TIME_FORMAT_FAILED("00300027", "开始时间或结束时间格式不正确"), TAG_TIME_SEQ_FAILED(
        "00300028", "起始时间小于结束时间，请确认！"), TAG_TIME_FORMAT_FAILED("00300029", "开始时间或结束时间格式不正确！"), TAG_TIMEPOINT_FORMAT_FAILED(
        "00300030", "时间格式不正确！"), PRICE_GT_LING("00300031", "非赠品商品价格必须大于0"), TAG_PRICE_STOCK_SKU_IS_NULL(
        "00300031", "查询结果为空，请确认SKU是否有效"), PRICE_BEGIN_END_FAILED("00300032", "变价开始时间应小于结束时间"), PRICE_BDATE_IS_NULL(
        "00300033", "开始日期不能为空"), PRICE_EDATE_IS_NULL("00300034", "结束日期不能为空"), PRICE_BEGIN_CURDATE_FAILED(
        "00300035", "变价只允许做预变价"),PRICE_PRODUCT_NOT_EXIST("00300036", "商品不存在价格信息"),

    /* 库存管理 301 孔庆富 */
    STOCK_OUTOFSTOCK_ERROR("00301101", "锁定数量大于可售库存数量"), STOCK_LOCK_SUCCEED("00301102", "锁库成功"), STOCK_LOCK_FAILED_ERROR(
        "00301103", "锁库失败"), STOCK_REDUCE_NULL_ERROR("00301104", "商品未锁定"), STOCK_REDUCE_DIFFER_ERROR(
        "00301105", "减库数量不等于锁库数量"), STOCK_REDUCE_SUCCEED("00301106", "减库成功"), STOCK_REDUCE_FAILED_ERROR(
        "00301107", "减库失败"), STOCK_UNLOCK_SUCCEED("00301108", "解锁成功"), STOCK_UNLOCK_FAILED_ERROR(
        "00301109", "解锁失败"), STOCK_REFUND_SUCCEED("00301110", "还库成功"), STOCK_REFUND_FAILED_ERROR(
        "00301111", "还库失败"), STOCK_IMPORT_ERROR("00301112", "请求数据超出200条或商品列表为空"), STOCK_TRANSFER_ERROR(
        "00301113", "变更数量大于可售数量"), STOCK_OPERATION_SUCCEED("00301114", "操作成功"), STOCK_OPERATION_FAILED_ERROR(
        "00301115", "操作失败"), STOCK_SHOPPEPROSID_IS_NULL("00301116", "专柜商品编码不能为空"), STOCK_NO_UNLOCK_DIFFER_ERROR(
        "00301117", "解锁数量不等于锁库数量"), STOCK_TYPE_IS_NULL("00301118", "库位类型不能为空"), STOCK_PROSUM_IS_NULL(
        "00301119", "变更数量不能为0"), STOCK_CHANNELSID_IS_NULL("00301120", "渠道不能为空"), STOCK_IMPORTSTOCK_ERROR(
        "00301121", "导入库存数只能是正整数"), STOCK_IMPORTOPERATOR_IS_NULL("00301122", "操作人不能为空"), STOCK_IMPORT_FAILED(
        "00301123", "导入库存失败"), STOCK_SHOPPEPROSID_IS_NOT_EXITS("00301124", "专柜商品不存在"), SAVE_EXCEPTION_FAILED(
        "00301125", "保存异常信息失败"), STOCK_SHOPPEPROSID_NOT_SALE("00301126", "专柜商品不可售"), STOCK_SHOPPEPROSID_NOT_SALESTOCK(
        "00301127", "专柜商品无可售库存"), STOCK_IMPORT_LOCKSUM_ERROR("00301128", "全量库存不能小于锁库数量"), STOCK_IMPORT_PUSH_ERROR(
        "00301129", "库存下发失败"), STOCK_IMPORT_TPYEALL_ERROR("00301130", "全量库存不允许导负库存"), STOCK_IMPORT_NEGATIVE_FAILED(
        "00301131", "可售库存不能小于0"), SKU_NOT_SALE("00301132", "商品不可售"),NOT_XK(
        "00301133", "专柜商品为非虚库商品"), NOT_XXHC("00301134", "专柜商品非先销后采商品"), NOT_ASSOCIATED(
        "00301135", "专柜商品非联营商品"),STOCK_TYPE_IS_ERROR("00301136", "库位操作类型为空或不正确"),
    /* 商品图片 302 孔庆富 */
    PICTURE_PRODUCTCODE_IS_NULL("00302021", "商品编码不能为空"), PICTURE_PHOTOCODE_IS_NULL("00302022",
        "照片编码不能为空"), PICTURE_URL_IS_NULL("00302023", "商品图片URL不能为空"), PICTURE_NUMBER_IS_NULL(
        "00302024", "商品图片排序号不能为空"), PICTURE_NUMBER_IS_ERROR("00302025", "商品图片排序号非数字"), PICTURE_ISMAIN_IS_ERROR(
        "00302026", "是否主图非数字"), PICTURE_ISMODEL_IS_ERROR("00302027", "是否模特图非数字"), PICTURE_ISTHUMBNAIL_IS_ERROR(
        "00302028", "是否缩略图非数字"), PICTURE_SAVE_SUCCEED("00302029", "图片保存成功"), PICTURE_SAVE_FAILED(
        "00302010", "图片保存失败"), PICTURE_COLORCODE_IS_NULL("00302011", "色系不能为空"), PICTURE_TYPE_IS_NULL(
        "00302012", "是否二次拍照不能为空"), PICTURE_PHOTONAME_IS_NULL("00302013", "图片名称不能为空"), PICTURE_NOT_ONLY(
        "00302014", "图片已存在");

    private String errorCode;
    private String memo;

    private ErrorCode() {
    };

    private ErrorCode(String errorCode, String memo) {
      this.errorCode = errorCode;
      this.memo = memo;
    }

    public String getErrorCode() {
      String syscode = PropertyUtil.getValue("/system.properties", "system.excption.code");
      if (syscode != null) {
        return errorCode.replaceFirst("00", syscode);
      } else {
        return errorCode;
      }
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
  }

  public enum ExcptionTypeCode {
    COMMON("100", "公共"), ORGAN("101", "组织机构"), FLOOR("102", "楼层"), SHOPPE("103", "专柜"), DICT("104",
        "字典表"), SALE_CHANNEL("105", "销售渠道"), BRAND("107", "品牌"), SUPPLY("108", "供应商"), CATEGORY(
        "109", "品类"), CONTRACT("110", "要约"), PRODUCT("111", "商品"), PRICE("300", "价格"), STORE("301",
        "库存"), PICTURE("302", "图片");
    private String code;
    private String name;

    private ExcptionTypeCode() {
    }

    private ExcptionTypeCode(String code, String name) {
      this.code = code;
      this.name = name;
    }

    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public static Map getErrorTypeMap() {
      Map map = new HashMap();
      ExcptionTypeCode[] ecs = ExcptionTypeCode.values();
      for (ExcptionTypeCode er : ecs) {
        map.put(er.getCode(), er.getName());
      }
      return map;
    }

    public static String getErrorCodeName(String code) {
      ExcptionTypeCode[] ecs = ExcptionTypeCode.values();
      for (ExcptionTypeCode er : ecs) {
        if (er.getCode().equals(code)) {
          return er.getName();
        }
      }
      return null;
    }
  }

  public static void main(String[] args) {
    String str = ExcptionTypeCode.getErrorCodeName("100");
    System.out.println(str + "");
  }
}
