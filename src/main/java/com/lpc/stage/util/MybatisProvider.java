package com.lpc.stage.util;

import com.lpc.stage.model.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by Stefan on 2018/4/27.
 */
public class MybatisProvider {

    public String saveRates(final Map<String, List<Rate>> map) {
        final List<Rate> rates = map.get("rates");
        return new SQL() {{
            INSERT_INTO("df_rate");
            String values = "";
            MessageFormat mf = new MessageFormat("(#'{'rates[{0}].rateLevel}, #'{'rates[{0}].rate})");
            for (int i = 0; i < rates.size(); i++) {
                values += mf.format(new Object[]{i});
                if (i < rates.size() - 1) {
                    values += ",";
                }
            }
            VALUES("rate_level, rate", values.substring(1, values.length() - 1));
        }}.toString();
    }

    public String saveProducts(final Map<String, List<InitProduct>> map) {
        final List<InitProduct> products = map.get("products");
        return new SQL() {{
            INSERT_INTO("df_product");
            String values = "";
            MessageFormat mf = new MessageFormat("(#'{'products[{0}].id}, #'{'products[{0}].attIds}, #'{'products[{0}].productName}," +
                    " #'{'products[{0}].description}, #'{'products[{0}].imageUrl}, #'{'products[{0}].remark})");
            for (int i = 0; i < products.size(); i++) {
                values += mf.format(new Object[]{i});
                if (i < products.size() - 1) {
                    values += ",";
                }
            }
            VALUES("id, att_ids, product_name, description, image_url, remark", values.substring(1, values.length() - 1));
        }}.toString();
    }

    public String saveProductPrices(final Map<String, List<ProductPrice>> map) {
        final List<ProductPrice> products = map.get("priceList");
        return new SQL() {{
            INSERT_INTO("df_product_price");
            String values = "";
            MessageFormat mf = new MessageFormat("(#'{'priceList[{0}].parentId}, #'{'priceList[{0}].parentName}, #'{'priceList[{0}].valIds}," +
                    " #'{'priceList[{0}].agentPrice}, #'{'priceList[{0}].salePrice}, #'{'priceList[{0}].imageUrl})");
            for (int i = 0; i < products.size(); i++) {
                values += mf.format(new Object[]{i});
                if (i < products.size() - 1) {
                    values += ",";
                }
            }
            VALUES("parent_id, parent_name, val_ids, agent_price, sale_price, image_url", values.substring(1, values.length() - 1));
        }}.toString();
    }

    public String saveAttributes(final Map<String, List<ProductAttribute>> map) {
        final List<ProductAttribute> attributes = map.get("attributes");
        return new SQL() {{
            INSERT_INTO("df_product_attr");
            String values = "";
            MessageFormat mf = new MessageFormat("(#'{'attributes[{0}].id}, #'{'attributes[{0}].attr}");
            for (int i = 0; i < attributes.size(); i++) {
                values += mf.format(new Object[]{i});
                if (i < attributes.size() - 1) {
                    values += ",";
                }
            }
            VALUES("id, attrName", values.substring(1, values.length() - 1));
        }}.toString();
    }

    public String saveAttributeValues(final Map<String, List<ProductAttributeValue>> map) {
        final List<ProductAttributeValue> vals = map.get("values");
        return new SQL() {{
            INSERT_INTO("df_product_attr_val");
            String values = "";
            MessageFormat mf = new MessageFormat("(#'{'values[{0}].id}, #'{'values[{0}].attr}");
            for (int i = 0; i < vals.size(); i++) {
                values += mf.format(new Object[]{i});
                if (i < vals.size() - 1) {
                    values += ",";
                }
            }
            VALUES("id, attrName", values.substring(1, values.length() - 1));
        }}.toString();
    }

    public String saveLines(final Map<String, List<OrderLine>> map) {
        final List<OrderLine> lines = map.get("lines");
        return new SQL() {{
            INSERT_INTO("df_order_line");
            String values = "";
            MessageFormat mf = new MessageFormat("(#'{'lines[{0}].order_id}, #'{'lines[{0}].product_id}, #'{'lines[{0}].product_name}" +
                    ", #'{'lines[{0}].line_status}, #'{'lines[{0}].quantity}, #'{'lines[{0}].original_price}, #'{'lines[{0}].real_price})");
            for (int i = 0; i < lines.size(); i++) {
                values += mf.format(new Object[]{i});
                if (i < lines.size() - 1) {
                    values += ",";
                }
            }
            VALUES("orderId, productId, productName, lineStatus, quantity, originalPrice, realPrice", values.substring(1, values.length() - 1));
        }}.toString();
    }

    public String queryOrder(final Map<String, String> map) {
        String query = map.get("query");
        String startDate = map.get("startDate");
        String endDate = map.get("endDate");
        String sql = "select * from df_order where created_time > #{startDate} and created_time < #{endDate}";
        if (!StringUtils.isEmpty(query)) {
            sql += " and buyer_name like #{query} or agent_name like #{query} or buyer_phone like #{query}";
        }
        return sql;
    }

}
