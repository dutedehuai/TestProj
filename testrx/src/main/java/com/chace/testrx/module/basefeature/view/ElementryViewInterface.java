package com.chace.testrx.module.basefeature.view;

import com.chace.testrx.model.ZBImageInfo;

import java.util.List;

/**
 * Created by chacewang on 16/9/23.
 */
public interface ElementryViewInterface {
    void updateStart();
    void updateImageView(List<ZBImageInfo> zbImageInfos);
    void updateEnd();
}
