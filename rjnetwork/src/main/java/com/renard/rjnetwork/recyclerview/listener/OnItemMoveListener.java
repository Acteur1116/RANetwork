package com.renard.rjnetwork.recyclerview.listener;

/**
 * Created by Riven_rabbit on 2018/11/28
 * Item 移动监听
 */
public interface OnItemMoveListener {
    /**
     * Item 移动
     * @param fromPosition  初始位置
     * @param toPosition    移动位置
     */
    void onItemMove(int fromPosition, int toPosition);
}
