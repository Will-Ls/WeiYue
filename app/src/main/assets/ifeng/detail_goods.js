var roy = {};
roy.GetLength = function(str) {
    return str.replace(/[^\x00-\xff]/g,"aa").length;
}

//构造自媒体商品样式
function getZmtGoodContentByType(good) {
//    var temp = '一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十';
//    var temp = '【商场同款】sdeer圣迪奥纯色折痕修长无袖衬衫S17280666sdeer圣迪奥纯色折痕修长无袖衬衫S17280666sdeer圣迪奥纯色折痕修长无袖衬衫S17280666sdeer圣迪奥纯色折痕修长无袖衬衫S17280666';
//    good.title =  temp;
//    good.source = temp;
//    good.price = '999999.99';

    var title = good.title;
    var type = good.type;
    var link = good.link;

    //商品状态
    var goodStatus = '去看看';
    if (good.status == '0') {
        goodStatus = '下架';
    } else if (good.status == '1') {
        goodStatus = '去看看';
    } else if (good.status == '2') {
        goodStatus = '预售';
    }

    //购买、预售、下架 按钮
    var sellStatus;
    if (good.status == '2') {
        sellStatus = '<div class="i-pbuy"><span>'+ goodStatus + '</span></div>';
    } else {
        sellStatus = '<div class="i-buy"><span>'+ goodStatus + '</span></div>';
    }

    //电影评分或者想看人数
    var scoreOrPersonNum;
    if (type == 'movie') {
        if (good.status == '2') {
            if (typeof(good.personNum) == 'undefined') {
                good.personNum = '0';
            }
            scoreOrPersonNum = '<div class="i-pcode"><span>' + good.personNum + '</span>人想看</div>';
        } else {
            scoreOrPersonNum = '<div class="i-code"><span>' + good.score + '</span>分</div>';
        }
    }

    //上映日期
    var playInfo = good.playInfo;

    var maxPriceLength = 9;
    var maxSourceLength = 6;
    var maxPriceSouceTotalLength = 12;
    var maxGoodTitleWidth = 54;  //商品的两行标题的最大字符宽

    if (type == 'goods') {
        var flag = false;
        while (roy.GetLength(title) >= maxGoodTitleWidth) {
               var tmpLength = title.length;
               if (tmpLength <= 1) {
                   break;
               }
               title = title.substring(0, tmpLength - 1- 1);
               flag = true;
        }
        if (flag) {
           title = title + '...';
        }
        var goodSource = good.source;
        var goodPrice = good.price;
        if (goodPrice == null || goodPrice == "undefined" || typeof(goodPrice) == "undefined"){
           goodPrice = '';
        }
        if(goodSource != null && goodSource != undefined && goodSource != ""){
            var sourceLength = goodSource.length;
            var priceLength = goodPrice.length;
            if (priceLength >= maxPriceLength) {
                goodSource = '';
            } else {
               if (sourceLength + priceLength > maxPriceSouceTotalLength) {
                   goodSource = goodSource.substring(0, maxPriceSouceTotalLength - priceLength - 1);
                   if(goodSource.length >= maxSourceLength){
                      goodSource = goodSource.substring(0, maxSourceLength - 1);
                   }
                   goodSource += "...";
               }
            }
        }
        var str = '<div class="item lef-pic wemedia_ad" goodlinktype="' + link.type + '" goodId="' + good.bs + '" goodlinkurl="' + link.url + '">'
                              +'<div class="i-thumb">'
                                  +'<div class="i-pic"><img class="goodimg" imgsrc="'+ good.thumbnail +'" src="" style="width:100%;height:100%;background-repeat:no-repeat;background-position:center;"></div>'
                              +'</div>'
                              +'<div class="i-metadata">'
//                                  +'<div class="i-title">' + title + '<div class="i-icon">商品</div></div>'
                                  +'<div class="i-title">' + title + '</div>'
                                  +'<div class="i-desc">'
                                      +'<div class="i-price">￥' + goodPrice + '</div>'
                                      +'<div class="i-source">' + goodSource + '</div>'
                                      + sellStatus
                                  +'</div>'
                              +'</div>'
                              +'<div style="clear:both" ></div>'
                  +'</div>';
         return str;
    }
    if (type == 'movie') {

        var str = '<div class="item  movie wemedia_ad" goodlinktype="' + link.type + '" goodId="' + good.bs + '" goodlinkurl="' + link.url + '">'
                               +'<div class="i-thumb">'
                                   +'<div class="i-pic"><img class="goodimg" imgsrc="'+ good.thumbnail +'" src="" style="width:100%;height:100%;background-repeat:no-repeat;background-position:center;"></div>'
                               +'</div>'
                               +'<div class="i-metadata1">'
//                                   +'<div class="i-title">' + title +  '<div class="i-icon">电影</div></div>'
                                   +'<div class="i-topline"><div class="i-title" style="display:inline-block;max-width:88%;overflow: hidden;float:left">' + title +  '</div><div class="i-icon" style="display:inline-block;clear:both">电影</div></div>'
                                   + scoreOrPersonNum
                                   +'<div class="i-desc">'
                                       +'<div class="i-words">' + good.description +  '</div>'
                                       +'<div class="i-time">' + playInfo + '</div>'
                                       + sellStatus
                                   +'</div>'
                               +'</div>'
                       +'</div>';
        return str;
    }
    if (type == 'fm') {

        var str = '<div class="item  movie wemedia_ad" goodlinktype="' + link.type + '" goodId="' + good.bs + '" goodlinkurl="' + link.url + '">'
                               +'<div class="i-thumb">'
                                   +'<div class="i-pic"><img class="goodimg" imgsrc="'+ good.thumbnail +'" src="" style="width:100%;height:100%;background-repeat:no-repeat;background-position:center;"></div>'
                               +'</div>'
                               +'<div class="i-metadata1">'
//                                   +'<div class="i-title">' + title +  '<div class="i-icon">音频</div></div>'
                                   +'<div class="i-topline"><div class="i-title" style="display:inline-block;max-width:88%;overflow: hidden;float:left">' + title +  '</div><div class="i-icon" style="display:inline-block;clear:both">音频</div></div>'
                                   +'<div class="i-editor">' + good.author + '</div>'
                                   +'<div class="i-instr">' + good.description +  '</div>'
                                   +'<div class="i-desc">'
                                       +'<div class="i-price"><span class="i-uprice">' + good.price + '</span><span class="i-sum">' + good.total + '</span></div>'
                                       + sellStatus
                                   +'</div>'
                               +'</div>'
                       +'</div>';
        return str;
    }
    if (type == 'book') {

       var title = good.title;
       if(title != null && title != undefined && title != ""){
           title = title.substring(0, maxTitleLength);
       }

       var description = good.description;
       if(description != null && description != undefined && description != ""){
         if(maxDescriptionLength.length > maxDescriptionLength){
           description = description.substring(0, maxDescriptionLength);
           description += "...";
         }
       }
        var str = '<div class="item  movie wemedia_ad" goodlinktype="' + link.type + '" goodId="' + good.bs + '" goodlinkurl="' + link.url + '">'
                               +'<div class="i-thumb">'
                                   +'<div class="i-pic"><img class="goodimg" imgsrc="'+ good.thumbnail +'" src="" style="width:100%;height:100%;background-repeat:no-repeat;background-position:center;"></div>'
                               +'</div>'
                               +'<div class="i-metadata1">'
//                                   +'<div class="i-title">' + title + '<div class="i-icon">小说</div></div>'
                                   +'<div class="i-topline"><div class="i-title" style="display:inline-block;max-width:88%;overflow: hidden;float:left">' + title +  '</div><div class="i-icon" style="display:inline-block;clear:both">小说</div></div>'
                                   +'<div class="i-editor">' + good.author + '</div>'
                                   +'<div class="i-instr">' + description +  '</div>'
                                   +'<div class="i-desc">'
                                       +'<div class="i-price"><span class="i-uprice">' + good.price + '</span></div>'
                                       + sellStatus
                                   +'</div>'
                               + '</div>'
                       +'</div>';
        return str;
    }
    return '';
}