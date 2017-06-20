package com.hola.dao.dougest;

import java.util.List;
import java.util.Map;
import org.jsoup.nodes.Document;
/**
 *  解析html文档抽象
 * @author Dougest 2017年5月4日    下午10:04:28
 *
 */
public interface DocumentAnalyzer {
	/**
     * 根据html文档对象获取List<Map>
     * @param document html文档对象
     * @return 结果
     */
    List<Map<String,Object>> forListMap(Document document);
}
