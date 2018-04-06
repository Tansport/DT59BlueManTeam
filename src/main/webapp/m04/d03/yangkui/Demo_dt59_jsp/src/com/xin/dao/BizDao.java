

package com.xin.dao;

import java.util.List;

import com.xin.entity.NewsInfo;
import com.xin.entity.UserInfo;

/**
 * Description:   <br/>
 * Date:     2018年4月3日 下午4:02:42 <br/>
 * @author   YangKui
 * @version
 * @see
 */
public interface BizDao {
boolean denglu(UserInfo user);

List<NewsInfo> all();
}

