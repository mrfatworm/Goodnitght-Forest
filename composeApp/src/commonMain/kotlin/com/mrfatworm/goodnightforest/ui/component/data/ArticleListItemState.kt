/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component.data

import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.img_booked_1
import goodnitght_forest.composeapp.generated.resources.img_booked_2
import goodnitght_forest.composeapp.generated.resources.img_booked_3
import goodnitght_forest.composeapp.generated.resources.img_popular_1
import goodnitght_forest.composeapp.generated.resources.img_popular_2
import goodnitght_forest.composeapp.generated.resources.img_popular_3
import goodnitght_forest.composeapp.generated.resources.img_suggest_1
import goodnitght_forest.composeapp.generated.resources.img_suggest_2
import org.jetbrains.compose.resources.DrawableResource

data class ArticleListItemState(
    val imgRes: DrawableResource,
    val title: String,
    val description: String
)

private val suggestArticle1 = ArticleListItemState(Res.drawable.img_suggest_1, "呼吸中止症的治療", "探討常見的失眠原因，如壓力、生活習慣")
private val suggestArticle2 = ArticleListItemState(Res.drawable.img_suggest_2, "輪班工作睡眠問題", "輪班工作者常如調整作息時間")
private val bookedArticle1 = ArticleListItemState(Res.drawable.img_booked_1, "失眠的原因及對策", "探討常見的失眠原因，如壓力、生活習慣")
private val bookedArticle2 = ArticleListItemState(Res.drawable.img_booked_2, "睡眠與精神健康", "睡眠是維持身體和心理健康的關鍵。長庚醫院")
private val bookedArticle3 = ArticleListItemState(Res.drawable.img_booked_3, "健康睡眠習慣", "評估智能手機、穿戴裝置和應用程式如何影響睡眠質量，以及如何使用這些科技來改善睡眠。")
private val popularArticle1 = ArticleListItemState(Res.drawable.img_popular_1, "睡眠不足的影響", "輪班工作者常如調整作息時間、營養建議和環境調整等。")
private val popularArticle2 = ArticleListItemState(Res.drawable.img_popular_2, "科技與睡眠", "評估智能手機、穿戴裝置和應用程式如何影響睡眠質量，以及如何使用這些科技來改善睡眠。")
private val popularArticle3 = ArticleListItemState(Res.drawable.img_popular_3, "自然療法改善睡眠", "溫熱的草藥茶，香薰擴香器散發著薰衣草精油的香氣，進行溫水泡腳")

val sampleSuggestArticleList = listOf(
    suggestArticle1, suggestArticle2
)

val sampleBookedArticleList = listOf(
    bookedArticle1, bookedArticle2, bookedArticle3
)

val samplePopularArticleList = listOf(
    popularArticle1, popularArticle2, popularArticle3
)