<!DOCTYPE html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="${ctx}/favicon.ico" rel="icon" type="image/x-icon" />
    <link href="${ctx}/slider/slider.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/common.css" rel="stylesheet" type="text/css" />
    <link href="${ctx}/css/index.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${ctx}/js/jquery.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.tools.js"></script>
    <script type="text/javascript" src="${ctx}/js/jquery.lazyload.js"></script>
    <script type="text/javascript" src="${ctx}/slider/slider.js"></script>
    <script type="text/javascript" src="${ctx}/js/common.js"></script>
    <style type="text/css">
        .header {
            margin-bottom: 0px;
        }
    </style>
    <script type="text/javascript">
        $().ready(function() {

            var $productCategoryMenuItem = $("#productCategoryMenu li");
            var $slider = $("#slider");
            var $newArticleTab = $("#newArticle ul.tab");
            var $hotGoodsImage = $("div.hotGoods img");

            $productCategoryMenuItem.hover(
                    function() {
                        $(this).children("div.menu").show();
                    }, function() {
                        $(this).children("div.menu").hide();
                    }
            );

            $slider.nivoSlider({
                effect: "random",
                animSpeed: 1000,
                pauseTime: 6000,
                controlNav: true,
                keyboardNav: false,
                captionOpacity: 0.4
            });

            $newArticleTab.tabs("ul.tabContent", {
                tabs: "li",
                event: "mouseover"
            });

            $hotGoodsImage.lazyload({
                threshold: 100,
                effect: "fadeIn",
                skip_invisible: false
            });

        });
    </script>
</head>
<body>


[#include "common/header.ftl"/]
<script>
    $.post("/cart/count", {}, function (data) {
        if (data.resultCode == 1) {
            var count = data.result;
            $("#headerCart").find('em').html(count);
        }
    });
</script>
<div class="container index">
    <div class="row">
        <div class="span2">
            <div id="productCategoryMenu" class="productCategoryMenu">
                <ul>
                [@product_category_root_list]
                    [#list productCategories as productCategory]
                        <li>
                            <div class="item">
                                <div>
                                    [@product_category_children_list parentId = productCategory.id]
                                        [#list productCategories as productCategory]
                                            <a href="${ctx}/goods/list/${productCategory.id}">
                                                <strong>${productCategory.name}</strong>
                                            </a>
                                        [/#list]
                                    [/@product_category_children_list]
                                </div>
                                <div>
                                    [@brand_list productCategoryId = productCategory.id]
                                        [#list brands as brand]
                                            <a href="${ctx}/goods/list/${brand.id}"> ${brand.name}</a>
                                        [/#list]
                                    [/@brand_list]
                                </div>
                            </div>
                            <div class="menu">
                                [@product_category_children_list parentId=productCategory.id limit=10]
                                    [#list productCategories as productCategory]
                                        <dl class="clearfix[#if productCategory_has_next]last[/#if]" >
                                            <dt>
                                                <a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a>
                                            </dt>
                                            [@product_category_children_list parentId=productCategory.id limit=10]
                                                [#list productCategories as productCategory]
                                                    <dd>
                                                    <a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a>
                                                    [#if productCategory_has_next]|[/#if]
                                                    </dd>
                                                [/#list]
                                            [/@product_category_children_list]
                                        </dl>
                                    [/#list]
                                [/@product_category_children_list]
                                <div class="auxiliary">
                                    <div>
                                        <strong>推荐品牌</strong>
                                        [@brand_list productCategoryId = productCategory.id limit=8]
                                            [#list brands as brand]
                                                <a href="${ctx}/brand/${brand.id}">${brand.name}</a>
                                            [/#list]
                                        [/@brand_list]
                                    </div>
                                    [@promotion_list productCategoryId = productCategory.id]
                                        [#if promotions?has_content]
                                            <div>
                                                <strong>热门促销</strong>
                                                [#list promotions as promotion]
                                                    <a href="${ctx}/promotion/${promotion.id}"
                                                       title="${promotion.title}">
                                                        <img src="${promotion.image}" alt="${promotion.title}"/>
                                                    </a>
                                                [/#list]
                                            </div>
                                        [/#if]
                                    [/@promotion_list]
                                </div>
                            </div>
                        </li>
                    [/#list]
                [/@product_category_root_list]
                </ul>
            </div>
        </div>
    [#--轮播广告--]
        <div class="span10">
            [@ad_position id=1 /]
        </div>
    </div>

    <div class="row">
        [#--热点广告--]
        <div class="span9">
            [@ad_position id=2 /]
        </div>
        [#--文章类别--]
        <div class="span3">
            <div id="newArticle" class="newArticle">
                <ul class="tab">
                [#assign articleCategoryAssign=null]
                    [@article_category_root_list count=2]
                        [#assign articleCategoryAssign = articleCategories]
                        [#list articleCategories as articleCategory]
                            <li>
                                <a href="${ctx}/article_category/${articleCategory.id}" target="_blank">
                                ${articleCategory.name}
                                </a>
                            </li>
                        [/#list]
                    [/@article_category_root_list]
                </ul>
                [#--分类下的文章类别--]
                [#list articleCategoryAssign as articleCategory]
                    <ul class="tabContent">
                        [@article_list categoryId=articleCategory.id count=6]
                            [#list articles as article]
                            <li>
                                <a href="${ctx}/article/${article.id}" title="${article.title}" target="_blank">
                                    ${article.title}
                                </a>
                            </li>
                            [/#list]
                        [/@article_list]
                    </ul>
                [/#list]
            </div>
        </div>
    </div>

    [#--中间广告--]
    <div class="row">
        <div class="span12">
            [@ad_position id=3 /]
        </div>
    </div>

    [#--获取分栏广告--]
    [#assign adsAssign=null]
    [@ad_list id=4 ]
        [#assign adsAssign = ads]
    [/@ad_list]
    [#--热门商品--]
    [@product_category_root_list limit=3]
        [#list productCategories as productCategory]
            <div class="row">
                <div class="span12">
                    <div class="hotGoods">
                        <dl class="title1">
                            <dt>
                                <a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a>
                            </dt>
                            [#--子分类--]
                            [@product_category_children_list parentId=productCategory.id limit=10]
                                [#list productCategories as productCategory]
                                    <dd>
                                        <a href="${ctx}/goods/list/${productCategory.id}">${productCategory.name}</a>
                                    </dd>
                                [/#list]
                            [/@product_category_children_list]
                        </dl>
                        <div>
                            [#--广告的展示--]
                            [#assign ad=adsAssign[productCategory_index]]
                            <a href="${ad.url}">
                                <img src="${ad.path}" alt="${ad.title}" title="${ad.title}">
                            </a>
                        </div>
                        <ul>
                            [@goods_list productCategoryId=productCategory.id hotId=3]
                                [#list goods as good]
                                    [#if good_index < 5]
                                        <li>
                                            <a href="${ctx}/goods/detail/${good.id}" title="${good.name}" target="_blank">
                                                <div>
                                                    <span title="${good.name}">${good.name}</span>
                                                    <em title="${good.caption}">${good.caption}</em>
                                                </div>
                                                <strong>￥${good.price}</strong>
                                                <img src="${ctx}/upload/image/blank.gif" data-original="${good.image}" />
                                            </a>
                                        </li>
                                    [#else ]
                                        <li class="low">
                                            <a href="${ctx}/goods/detail/${good.id}" title="${good.name}" target="_blank">
                                                <img src="/upload/image/blank.gif" data-original="${good.image}" />
                                                <span title="${good.name}">${good.name}</span>
                                                <strong>${good.price}</strong>
                                            </a>
                                        </li>
                                    [/#if]
                                [/#list]
                            [/@goods_list]
                        </ul>
                    </div>
                </div>
            </div>
        [/#list]
    [/@product_category_root_list]
    <div class="row">
        <div class="span12">
            [@ad_position id = 5 /]
        </div>
    </div>

    [#--品牌展示--]
    <div class="row">
        <div class="span12">
            <div class="hotBrand">
                <ul class="clearfix">
                    [@brand_list limit=10]
                        [#list brands as brand]
                            <li>
                                <a href="${ctx}/brand/${brand.id}" title="${brand.name}">
                                    <img src="${brand.logo}" alt="${brand.name}" />
                                </a>
                            </li>
                        [/#list]
                    [/@brand_list]
                </ul>
            </div>
        </div>
    </div>
</div>
[#include "common/footer.ftl"/]
</body>
</html>