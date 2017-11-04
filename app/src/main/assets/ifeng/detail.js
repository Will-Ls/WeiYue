var cropper,
    relative_cropper,
    sale_cropper,
    FIRSTFONT,
    image_index=0,
    SCREEN_WIDTH,
    IMGE_DEFAULT_HEIGHT = 90.5,
    IMAGE_PLACEHOLDER_WIDTH,
    IMAGE_PLACEHOLDER_HEIGHT,
    RELATIVE_IMAGE_PLACEHOLDER_WIDTH, //早前报道图片宽
    RELATIVE_IMAGE_PLACEHOLDER_HEIGHT,//早前报道图片高
    SALE_IMAGE_PLACEHOLDER_WIDTH, //特卖图片宽
    SALE_IMAGE_PLACEHOLDER_HEIGHT,//特卖图片高
    PLACEHOLDER_SLOPE = 174 / 294, // 标准框比例
    CONTENT_PADDING = 24, // 两侧空白区域
    blank = 10,
//顶部大图比例
    TOP_BANNER_SLOPE = 530/720,
    imgQuene = [],
    srcs = [],
    VOTEDATA,//投票数据
    display = 0, //列表展示标志
    topFlag = 0,
    delatHeight = 0,
    loadMode,
    offlineMode,
    claimer = false, //是否有免责声明
    VIDEO_SLOP = 440/670,//视频宽高比
    isLoadAdv01=false,
    video_p = '<!-- IFENG_DOC_VIDEO -->',
    slide_p = '<!-- IFENG_DOC_SLIDE -->',
    survey_p= '<!-- IFENG_DOC_SURVEY -->',
    center_ad_p='<!-- IFENG_DOC_ADVERT -->',
    audio_p = '<!-- IFENG_DOC_AUDIO -->',
    GOOD_P_PREFIX = '<!-- IFENG_DOC_GOODS=',  //自媒体商品标签前缀（完整标签为 <!-- IFENG_DOC_GOODS=key5 --> ）
    GOOD_P_SUFFIX = ' -->',//自媒体商品标签后缀（注意有空格）
    surveyArry=[],
    survey_array_num = 0,
    FONTS={
        'smaller'  : 0,
        'small'    : 1,
        'mid'      : 2,
        'big'      : 3,
        'bigger'   : 4,
        'huge'     : 5,
        'biggest'  : 6,
    },
    nophoto_arrays=[	//无图模式或离散图片加载状态
        "nophoto_load.png",    //点击加载
        "nophoto_loading.png", //加载中
        "nophoto_load.png",    //加载失败
    ],
    hasSurveyAd = false,        //是否有民调广告
    SURVEY_AD_WIDTH = 0,            //民调广告宽
    SURVEY_AD_HEIGHT = 0,           //民调广告高
    SURVEY_AD_RADIO = 330 / 83, //民调广告宽高比
    hasBodyAd = false,            //是否有正文（中韩频道）广告
    BODY_AD_WIDTH = 0,            //正文广告宽
    BODY_AD_HEIGHT = 0,           //正文广告高
    BODY_AD_CENTER_RADIO = 480 / 400;    //正文中间通发广告宽高比
    BODY_AD_RADIO = 668 / 202;    //正文广告宽高比


// 监听 deviceready 事件 执行 init 方法初始化逻辑
window.addEventListener('deviceready', init, false);

// 初始化所有业务逻辑
function init(e) {

    console.log("init");
    loadMode = ifeng.is2g3gloadMode();
    offlineMode = ifeng.isOfflineMode();
    if(offlineMode) {
        nophoto_arrays = [
            "offline_load.png",
            "offline_loading.png",
            "offline_load.png"
        ];
    }

    SCREEN_WIDTH = e.clientWidth;
    IMAGE_PLACEHOLDER_WIDTH = e.clientWidth;
    IMAGE_PLACEHOLDER_HEIGHT = Math.round(IMAGE_PLACEHOLDER_WIDTH
        * PLACEHOLDER_SLOPE);
    RELATIVE_IMAGE_PLACEHOLDER_WIDTH = IMAGE_PLACEHOLDER_WIDTH-66;
    RELATIVE_IMAGE_PLACEHOLDER_HEIGHT = Math.round(RELATIVE_IMAGE_PLACEHOLDER_WIDTH
        * PLACEHOLDER_SLOPE);
    SALE_IMAGE_PLACEHOLDER_WIDTH = IMAGE_PLACEHOLDER_WIDTH-24;
    SALE_IMAGE_PLACEHOLDER_HEIGHT = Math.round(SALE_IMAGE_PLACEHOLDER_WIDTH
        * PLACEHOLDER_SLOPE);
    cropper = new ImageCropper(new StandPlaceholderCropStrategy(
        IMAGE_PLACEHOLDER_WIDTH));
    relative_cropper = new ImageCropper(new StandPlaceholderCropStrategy(
        RELATIVE_IMAGE_PLACEHOLDER_WIDTH));
    sale_cropper = new ImageCropper(new StandPlaceholderCropStrategy(
        SALE_IMAGE_PLACEHOLDER_WIDTH));
    // 确定图片区域大小（图集和视频底图使用默认高度）
    try {
        var sheet = document.getElementsByTagName('link')[0].sheet;
        sheet.insertRule('.content .video {min-height:' + IMAGE_PLACEHOLDER_HEIGHT
            + 'px}');
        sheet.insertRule('.content .slide {min-height:' + IMAGE_PLACEHOLDER_HEIGHT
            + 'px}');
    } catch (e) {
        ifeng.reload(datas.getDocumentId());
        return false;
    }
    //民调广告
    var hasData = datas.getSurveylistJson();
    if (hasData != null && hasData != "" && hasData != 'undefined') {
       hasSurveyAd = true;
    }
    if (hasSurveyAd) {
        SURVEY_AD_WIDTH = SCREEN_WIDTH - 24;
        SURVEY_AD_HEIGHT = Math.round(SURVEY_AD_WIDTH / SURVEY_AD_RADIO);
        var surveyAdWrapper = document.getElementById('survey_ad_wrapper');
        surveyAdWrapper.style.display = 'block';
        surveyAdWrapper.onclick = function() {
            ifeng.surveyAdClick();
        }
        var image = document.getElementById('survey_ad_img');
        image.style.width = SURVEY_AD_WIDTH + 'px';
        image.style.height = SURVEY_AD_HEIGHT + 'px';
    }
    //正文（中韩频道/本地）广告
    var isChannelHasBodyAd = ifeng.isChannelHasBodyAd();
    var adData;
    if (isChannelHasBodyAd) {
        var bodyAdData = datas.getRandomBodyAdvertJson();
        if (bodyAdData != null && bodyAdData != "" && bodyAdData != 'undefined') {
           hasBodyAd = true;
           adData = JSON.parse(bodyAdData);
        }
    }
    if (hasBodyAd) {
        BODY_AD_WIDTH = SCREEN_WIDTH - 24;
        BODY_AD_HEIGHT = Math.round(BODY_AD_WIDTH / BODY_AD_RADIO);
        var bodyAdWrapper = document.getElementById('body_ad_wrapper');
        bodyAdWrapper.style.width = BODY_AD_WIDTH + 2 + 'px';
        bodyAdWrapper.style.display = 'block';
        bodyAdWrapper.onclick = function() {
            ifeng.bodyAdClick(adData.url, adData.title);
        }

        var bodyAdImage = document.getElementById('body_ad_img');
        var loadMessage = '<span class="load-message">正在载入...</span>';
        bodyAdImage.innerHTML = loadMessage;
        bodyAdImage.style.width = BODY_AD_WIDTH + 'px';
        bodyAdImage.style.height = BODY_AD_HEIGHT + 'px';

        var bodyAdTitle = document.getElementById('body_ad_title');
        bodyAdTitle.innerHTML = adData.title;
    }
    // 写入标题
    document.getElementById('title').innerHTML = datas.getTitle();
    initSource(datas);
//    // 写入来源 大于6字 去掉时间时分部分
//    var sourceText = datas.getSource(),
//        sourceEl = document.getElementById('source'),
//        sliceIndex = -3;
//    if (sourceText && sourceText !== '未知') {
//        if(sourceText.length > 5) sliceIndex = -9;
//        sourceEl.innerHTML = sourceText.substring(0, 10);
//    } else {
//        sourceEl.style.display = 'none';
//    }
//
//    // 写入时间
//    document.getElementById('time').innerHTML = datas.getEditTime().replace(
//        /-/g, '/').slice(0, sliceIndex);
    // 设置大小字体
    setFontSize(datas.getFontSize());
    // 处理图片后 填充正文内容
    preprocessImage(formatText(datas.getText()),
        document.getElementById('content'));

    //初始化音频
    initAudio();

    //增加作者和责任编辑
    initEditorCode(datas.getAuthor(),datas.getEditorcode());
    //初始化相关文章
    initInsertNews(datas.getTipsData());
    //初始化免责声明
    initClaimer(datas.getDisclaimer(), datas.getOriginalLink());
    //初始化赞和举报
    initSupportAccusation(datas.getDocumentId())
    //分享
    initShare();
    //初始化 正文底部的标签栏。
//	initBottomContentLabel(datas.getContentLabel());
    //初始化顶部banner图
    initTopBanner(datas);
//    initSubscribe(datas);



    // 初始化相关新闻
    //  initRelativeNews();

    //初始化相关阅读
    //   initRelateDocData();

    // 初始化推荐文章
//	initRecommendDocData();

    // 初始化精彩图集
//	initRecommendSlideData();

    // 底部线
//	initBottomLine();

    // 加载文字链广告
    // Ground.loadAdv01(datas.getDocumentId(), initAdv01, null);

    // 加载新增文字链广告
    //  Ground.loadAdv02(datas.getDocumentId(), initAdv02, null);
    //加载图片广告
//      Ground.loadAdv2(datas.getDocumentId(), initAdv2, null);

    //处理调查，填充正文

    //加载投票信息
    if(!offlineMode) {
        Ground.loadVote(buildVote, null);
    }
    // 加载评论数据
    var commentsUrl = datas.getCommentsUrl() || datas.getWwwurl();
    Ground.getHotComments(commentsUrl, datas.getDocumentId(), initComment, null);
    // 点击进评论页的2个入口
   if (hasBodyAd) {
       ifeng.getBodyAdImage(adData.thumbnail);
   }

}

function prependChild(parent,newChild){
    if(parent.firstChild){
        parent.insertBefore(newChild,parent.firstChild);
    } else {
        parent.appendChild(newChild);
    }
    return parent;
}

// 底部横线
function initBottomLine() {
    document.getElementById('bottom-divider').style.display = 'block';
}


//处理正文中图片
function processImage(cropper,default_height,content,container,imgInfo) {
    var loadMessage = '';
    if(loadMode!=1 && !offlineMode) {
        loadMessage = '<span class="load-message">正在载入...</span>';
    }
    var fragment = document.createElement('div');

    fragment.innerHTML = content;
    var imgEls = Array.prototype.slice.call(fragment.getElementsByTagName('ifengimg')), isFormat = true;
    //如果传过来的json数据格式错误，使用默认底图
    if (!imgInfo || Object.prototype.toString.call(imgInfo) !== '[object String]') {
        isFormat = false;
    }
    try {
        try{
            var imgObj = JSON.parse(imgInfo);
        } catch (e) {
            imgObj = undefined;
        }
        for ( var i = 0; i < imgEls.length; i++) {
            var img = imgEls[i], parent = img.parentNode, placeholder = document
                .createElement('div');
            if (!img.getAttribute('src')) {
                continue;
            }
            var imgUrl = img.getAttribute('src');
            var isSale = false;
            try {
                isSale = (img.className == "clientSale_img") || (img.parentNode.parentNode.className == "product_img");
            }catch(e){}
            var image_height = '';
            placeholder.className = 'placeholder';
            placeholder.setAttribute('src', img.getAttribute('src'));
            placeholder.setAttribute('index', i+image_index);
            placeholder.setAttribute('sale_flag', (isSale?"1":"0"));
            placeholder.setAttribute('loadState', 'loading');
            srcs.push(img.getAttribute('src'));
            //初始化默认底图的高（根据屏幕的宽和服务器传过来的高）
            if (isFormat&&imgObj&&imgObj[img.getAttribute('src')]) {
                var width = imgObj[img.getAttribute('src')].width, height = imgObj[img
                    .getAttribute('src')].height;
                if (width && height) {
                    if(isSale) {
                        result = sale_cropper.getResult(width, height);
                    } else {
                        result = cropper.getResult(width, height);
                    }
                    if(result.height == 0) {
                        image_height =  (isSale?SALE_IMAGE_PLACEHOLDER_HEIGHT:default_height)+ 'px';
                    } else {
                        image_height =  result.height+ 'px';
                    }
                } else {
                    // 如果没有获取到高，就用默认高
                    image_height =  (isSale?SALE_IMAGE_PLACEHOLDER_HEIGHT:default_height)+ 'px';
                }
            } else {
                var reg= new RegExp("_w(\\d+)_h(\\d+)","g");
                var result = null,next_result;

                while((next_result=reg.exec(imgUrl))!=null) {
                    result = next_result;
                };
                var w=0, h=0;
                if(result&&result.length==3) {
                    w = result[1];
                    h = result[2];
                }
                if(w && h) {
                    if(isSale) {
                        result = sale_cropper.getResult(w, h);
                    } else {
                        result = cropper.getResult(w, h);
                    }
                    if(result.height == 0) {
                        image_height = (isSale?SALE_IMAGE_PLACEHOLDER_HEIGHT:default_height)+ 'px';
                    } else {
                        image_height = result.height+'px';
                    }
                } else {
                    // 如果没有获取到高，就用默认高
                    image_height = (isSale?SALE_IMAGE_PLACEHOLDER_HEIGHT:default_height)+ 'px';
                }
            }
            if(offlineMode || loadMode == 1) {
                placeholder.style.height = placeholder.style.minHeight = IMGE_DEFAULT_HEIGHT+'px';
                placeholder.setAttribute('image_height',image_height);
            } else {
                placeholder.style.height = placeholder.style.minHeight = image_height;
            }

            placeholder.innerHTML= loadMessage;
            if(isSale) {
                try {
                    placeholder.style.marginBottom = "0px";
                    parent.setAttribute("href",parent.getAttribute("href")+"sale_flag");

                    var link_wrapper = parent.parentNode.parentNode.getElementsByClassName("product_link");

                    if(link_wrapper && link_wrapper.length>0 &&	link_wrapper[0].childNodes && link_wrapper[0].childNodes.length>0) {
                        link_wrapper[0].childNodes[0].setAttribute("href",link_wrapper[0].childNodes[0].getAttribute("href")+"sale_flag");
                    }

                    parent.replaceChild(placeholder, img);
                }catch(e) {
                    sendWebLog('sale img error', datas.getText());
                    try{
                        parent.parentNode.parentNode.style.display="none";
                    }catch(e) {
                    }
                }
            } else {
                parent.parentNode.replaceChild(placeholder, parent);
            }

        }
        image_index+=imgEls.length;
    }catch (e){
        sendWebLog('text img error', datas.getText());
    }
    return fragment.innerHTML;
}


//初始化相关文章
function initInsertNews(tip) {

    if (!tip
        || Object.prototype.toString.call(tip) !== '[object String]') {
        return false;
    }

    var tipObj = JSON.parse(tip);
    var content = tipObj.content;
    document.getElementById('news-channelName').innerText = tipObj.channelName;
    document.getElementById('news-title').innerText = tipObj.title;

    // 写入来源 大于6字 去掉时间时分部分
    var sourceText = tipObj.source,sliceIndex = -3,
        sourceEl = document.getElementById('news-source');
    if (sourceText && sourceText !== '未知') {
        if(sourceText.length > 5) sliceIndex = -9;
        sourceEl.innerHTML = sourceText.substring(0, 8);
    } else {
        sourceEl.style.display = 'none';
    }

    // 写入时间

    document.getElementById('news-time').innerHTML = tipObj.time.replace(
        /-/g, '/').slice(0, sliceIndex);

    var container = document.getElementById('news-content');
    var imgInfo = datas.getTipImgJson();

    content = processImage(relative_cropper,RELATIVE_IMAGE_PLACEHOLDER_HEIGHT,content, container, imgInfo);
    document.getElementById('news-content').innerHTML = content;

    document.getElementById('insert-news').style.display = 'block';

    var container = document.getElementById('ifeng-article');
    container.style.paddingBottom = '6px';

}

//初始化自媒体免责声明
function initClaimer(disclaimer, originalLink) {
    var success = false;
    if (disclaimer
        && Object.prototype.toString.call(disclaimer) === '[object String]') {
        document.getElementById("disclaimer").innerText = disclaimer;
        success = true;
    }
    if(originalLink
        && Object.prototype.toString.call(originalLink) === '[object String]') {
        success = true;
        var originBtn  = document.getElementById("originBtn");
        originBtn.innerText = "阅读原文";
        originBtn.onclick = function() {
            ifeng.jump('webfull', originalLink,"","disclaimer");
        };
    } else {
        document.getElementById("originBtn").style.display = "none";
        if(success) {document.getElementById("disclaimer").marginBottom = "0px";}
    }
    if(success) {
        if(topFlag == 0) {
            document.getElementById('ifeng-article').style.paddingBottom = "0px";
        }
        document.getElementById("disclamer_wrapper").style.display = "block";
        claimer = true;
    }
}

function supportSuccess() {
    var supportCountItem = document.getElementById('support-count');
    var count = supportCountItem.innerText;
    if(count) {
        supportCountItem.innerText = ''+(parseInt(count)+1);
    }	else {
        supportCountItem.innerText = '1';
    }
    var supportIcon = document.getElementById('support-icon');
    supportIcon.src = 'support_btn_clicked.png';
    supportIcon.setAttribute('supportFlag','2');
}
function supportFail() {
    var supportIcon = document.getElementById('support-icon');
    supportIcon.setAttribute('supportFlag','3');
};

//初始化赞，举报
function initSupportAccusation() {
    var bindAttr = function(ele,func) {
        ele.onclick = func;
    };
    var support_ele = document.getElementById('detail_support');
    var support_int = Number(ifeng.getSupportNum());
    if (ifeng.isSupported() == "1") {
        support_ele.src = 'detail_support_clicked.png';
        support_int = support_int+1;
        console.info('jslog support ' + support_int);
        } else {
        support_ele.src = 'detail_support_unclick.png';
    }
    document.getElementById('detail_support_value').innerText = support_int;
    bindAttr(document.getElementById('detail_support_container'),
        function() {
        console.info('jslog :'+'support src: ' +support_ele.src);
            if (support_ele.src ==='file:///android_asset/detail_support_clicked.png') {
                ifeng.detailSupport(0);
                support_int = support_int-1;
                document.getElementById('detail_support_value').innerText = support_int;
                support_ele.src = 'detail_support_unclick.png';
            } else {
                ifeng.detailSupport(1);
                support_int = support_int+1;
                document.getElementById('detail_support_value').innerText = support_int;
                support_ele.src = 'detail_support_clicked.png';
            }
        });
    bindAttr(document.getElementById('detail_accusation_container'),
        function() {
            ifeng.detailSupport(2);
        });
    document.getElementById('support_accusation').style.display = 'block';
}
//初始化分享
function initShare() {

    var bindAttr = function(ele,fuc,mouseOver,mouseOut) {
        ele.onclick = fuc;
        ele.ontouchstart = function() {
            var node = this;
            mouseOver(node);
            setTimeout(function() {
                mouseOut(node);
            }, 500);
        };
        ele.ontouchend = function() {
            mouseOut(this);
        };
        ele.ontouchmove = function() {
            mouseOut(this);
        };
    };

    bindAttr(document.getElementById('weichat-share'),
        function() {
            ifeng.shareDetail(1);
        },
        function(node) {
            node.src = 'weichat_clicked.png';
        },function(node) {
            node.src = 'weichat.png';
        });
    bindAttr(document.getElementById('friend-share'),
        function() {
            ifeng.shareDetail(2);
        },
        function(node) {
            node.src = 'friend_clicked.png';
        },function(node) {
            node.src = 'friend.png';
        });
    bindAttr(document.getElementById('blot-share'),
        function() {
            ifeng.shareDetail(3);
        },
        function(node) {
            node.src = 'blot_clicked.png';
        },function(node) {
            node.src = 'blot.png';
        });

    document.getElementById('content-share').style.display = 'block';

}

//文章标签
function initBottomContentLabel(mContentLabels){
    if(null != mContentLabels && undefined != mContentLabels && "" != mContentLabels){
        var container = document.getElementById('ifeng-article');
        container.style.paddingBottom = '0px';
        var mLabelArr = mContentLabels.split(",");

        if(null != mLabelArr && mLabelArr.length > 0){
            //标签内容非空，展示标签。
            document.getElementById("tag-content-label").style.display = 'block';
            document.getElementById("items-content-label").style.display = 'block';

            var mLabelContent, mLabelSpan;
            var fragment = document.createDocumentFragment();
            var mArrLength = mLabelArr.length;
            for(var i = 0; i < mArrLength - 1; i ++){
                mLabelContent = mLabelArr[i];

                if(null != mLabelContent && undefined != mLabelContent && "" != mLabelContent){
                    //渲染第i个标签内容。
                    mLabelSpan = document.createElement("span");
                    mLabelSpan.style.paddingRight = "10px";
                    mLabelSpan.style.display = "inline-block"; //tag词语不截断
                    mLabelSpan.innerText = "#" + mLabelContent;
                    mLabelSpan.onclick = function(){
                        ifeng.goToSearch(this.innerText);
                    }
                    fragment.appendChild(mLabelSpan);
                }
            }

            if(mArrLength - 1 >= 0){
                mLabelContent = mLabelArr[mArrLength - 1];
                if(null != mLabelContent && undefined != mLabelContent && "" != mLabelContent){

                    mLabelSpan = document.createElement("span");
                    mLabelSpan.style.display = "inline-block";
                    mLabelSpan.innerHTML = "#" + mLabelContent;
                    mLabelSpan.onclick = function(){
                        ifeng.goToSearch(this.innerText);
                    }
                    fragment.appendChild(mLabelSpan);
                }

            }

            document.getElementById("items-content-label").appendChild(fragment);
            document.getElementById("label_wrapper").style.display = 'block';

        }
    }
}

// 设置正文字体
function setFontSize(fs) {
    var cdom = document.getElementById('content');
    if(fs){
        if(FIRSTFONT){
            var offset = FONTS[fs] - FONTS[FIRSTFONT];
            var spans = document.getElementsByName('content_span');
            for(var i=0; i<spans.length; i++){
                var spanClass = spans[i].getAttribute('class');
                for(var font in FONTS){
                    if(FONTS[font] == FONTS[spanClass]+offset){
                        spans[i].setAttribute('class', font);
                    }
                }
            }
        }
        FIRSTFONT = fs;
        cdom.className = 'content ' + fs;
//        console.log(cdom.innerHTML);
    }
    //字体大小改变时，重新定位音频控件的位置
    initAudio();
}

function getRecommentItem(items) {
    var i, itemLength = items.length,content = '';
    for(i=0;i<itemLength;i++) {
        if(items[i].thumbnail) {
            content+= '<div type="'+items[i].type+'" linkUrl="'+items[i].url+'" class="recommend-container"><div class="recommend-left"><img src="'+(loadMode==1?"list_no_img.JPG":"list_default.jpg")+'" recommendSrc="'+
                items[i].thumbnail+'"/></div><div class="recommend-right"><span>'+items[i].title+'</span></div></div>';
        } else {
            content+= '<div type="'+items[i].type+'" linkUrl="'+items[i].url+'" class="recommend-container"><div class="recommend-right" style="padding-left:0px;min-height:64px;height:64px;overflow:hidden;"><span>'+items[i].title+'</span></div></div>';
        }
        //	if(i != itemLength-1) {
        //		content+='<div style="padding-left:12px;padding-right:12px;"><div class="recommend-sub-divider" style="display:block;margin-bottom:11px;">&nbsp;</div></div>';
        //	}
    }
    return content;
}

//初始化相关阅读的条目
function getReadContentItem(items) {
    var i, itemLength = items.length, content = '';
    for (i = 0; i < itemLength; i++) {
        var type = items[i].type;

        switch (type) {
            case 'doc':
                if (items[i].thumbnail) {
                    content += '<div type="' + items[i].type + '" linkUrl="' + items[i].link.url + '" class="relate-doc-container"><div class="recommend-left"><img src="' + (loadMode == 1 ? "list_no_img.JPG" : "list_default.jpg") + '" readImgSrc="' +
                        items[i].thumbnail + '"/></div><div class="recommend-right"><span>' + items[i].title + '</span></div></div>';
                } else {
                    content += '<div type="' + items[i].type + '" linkUrl="' + items[i].link.url + '" class="relate-doc-container"><div class="recommend-right" style="padding-left:0px;min-height:54px;height:54px;overflow:hidden;padding-top:4px;padding-bottom:6px;"><span>' + items[i].title + '</span></div></div>';
                }
                break;
            case 'slide':
                content += initReadSlideData(items[i]);
                break;

        }



    }


    if (datas.getFeatureChannel()
        && Object.prototype.toString.call(datas.getFeatureChannel()) === '[object String]') {
        content += '<div id="news-title-line-read" class="relative-doc-panel-img"  style="margin-left:14px;margin-right:18px;">&nbsp;</div>';
        content += '<div type="search" class="read-content-search" style="min-height:24px;height:24px;overflow:hidden;color:red"><span>点击进入「'+datas.getFeatureChannel()+'」频道</span></div>';

    }

    return content;
}

// 初始化推荐文章
function initRecommendDocData() {
    var recommendDoc = datas.getRecommendDocData();
    if (!recommendDoc
        || Object.prototype.toString.call(recommendDoc) !== '[object String]') {
        return false;
    }
    var recommendDocObj = JSON.parse(recommendDoc);
    var recommendDoc = document.getElementById('recommend-doc');
    recommendDoc.innerHTML = getRecommentItem(recommendDocObj);

    loadListImages(recommendDoc,'recommendSrc');

    var childNodes = recommendDoc.childNodes;
    for(var ele in childNodes) {
        childNodes[ele].onclick = function() {
            this.lastChild.style.color = '#8494a8';
            var type = this.getAttribute('type');
            switch(type) {
                case 'doc':
                    ifeng.jump('doc', this.getAttribute('linkUrl'),"","recommend_doc");
                    break;
                case 'slide':
                    ifeng.jump('slide', this.getAttribute('linkUrl'),"","recommend_doc");
                    break;
                case 'web':
                    ifeng.jump('webfull', this.getAttribute('linkUrl'),"","recommend_doc");
                    break;
                default:
                    ifeng.jump('webfull', this.getAttribute('linkUrl'),"","recommend_doc");
            }
        };
    }
    document.getElementById('recommend-doc-title').style.display = 'block';
    recommendDoc.style.display ='block';
    display|=2;


    var imgWidth = document.getElementById('news-title-left-img-recommend').offsetWidth;
    var contentWidth = document.getElementById('news-title-content-recommend').offsetWidth;
    var lineWidth = SCREEN_WIDTH-contentWidth-imgWidth-blank;
    document.getElementById('news-title-line-recommend').style.width= lineWidth+'px';

}

// 初始化相关阅读
function initRelateDocData() {
    var relateDoc = datas.getRelateDocs();
    if (!relateDoc
        || Object.prototype.toString.call(relateDoc) !== '[object String]') {
        return false;
    }
    var relateDocObj = JSON.parse(relateDoc);
    var relateDoc = document.getElementById('relate-doc');
    relateDoc.innerHTML = getReadContentItem(relateDocObj);

    loadListImages(relateDoc,'readImgSrc');

    var childNodes = relateDoc.childNodes;
    for(var ele in childNodes) {
        childNodes[ele].onclick = function() {
            var type = this.getAttribute('type');
            switch(type) {
                case 'doc':
                    this.lastChild.style.color = '#8494a8';
                    ifeng.jump('doc', this.getAttribute('linkUrl'),"","relateDocs");
                    break;
                case 'slide':
                    this.firstChild.style.color = '#8494a8';
                    ifeng.jump('slide', this.getAttribute('linkUrl'),"","relateDocs");
                    break;
                case 'web':
                    this.lastChild.style.color = '#8494a8';
                    ifeng.jump('webfull', this.getAttribute('linkUrl'),"","relateDocs");
                    break;
                case 'search':
                    this.lastChild.style.color = '#8494a8';
                    var featureChannel = datas.getFeatureChannel();
                    ifeng.goToSearchDetail(featureChannel);
                    break;
                default:
                    this.lastChild.style.color = '#8494a8';
                    ifeng.jump('webfull', this.getAttribute('linkUrl'),"","relateDocs");
            }
        };
    }
    document.getElementById('relativeReadPanel').style.display = 'block';
    relateDoc.style.display ='block';
    display|=2;


    var imgWidth = document.getElementById('relate-title-left-img-read').offsetWidth;
    var contentWidth = document.getElementById('relate-title-content-read').offsetWidth;
    var lineWidth = SCREEN_WIDTH-contentWidth-imgWidth-blank-5;
    document.getElementById('relate-title-line-read').style.width= lineWidth+'px';


}

//下载图片
function loadListImages(docs,srcName) {
    var imgs = docs.getElementsByTagName('img');
    for(var i=0;i<imgs.length;i++) {
        var imageDom = imgs[i],imageSrc = imageDom.getAttribute(srcName);
        if(imageSrc) {
            Ground.loadImageDirectly(imageSrc, null,
                loadImageSuccessInterceptor(imageDom, i),
                loadImageFailInterceptor(imageDom, imageDom.getAttribute(srcName)), 'false');
        }
    }
}



// 初始化精彩图集
function initRecommendSlideData() {
    var likeData = datas.getRecommendSlideData();
    if (!likeData
        || Object.prototype.toString.call(likeData) !== '[object String]') {
        return false;
    }

    var imageWidth = ((IMAGE_PLACEHOLDER_WIDTH-10)>>1);
    var imageHeight = Math.round(imageWidth*55/81);
    for(var index=0, likeObj = JSON.parse(likeData),
            length = likeObj.length;index<length;index++) {
        var targetDiv = document.getElementById('like-item-'+index), targetHtml =
            '<div class="likeItem" style="display:inline" ><img src="'+(loadMode==1?"album_no_img.JPG":"album_default.JPG")+'" width="'+imageWidth+'" height="'+
            imageHeight+'" likeSrc="'+likeObj[index].thumbnail+'"/></div><br/><div style="display:inline" class="likeItem" ><div width="'+imageWidth+'" class="like-item-title">'+
            likeObj[index].title+'</div></div>';
        targetDiv.style.width = imageWidth+"px";
        targetDiv.innerHTML = targetHtml;
        loadListImages(targetDiv, 'likeSrc');
        targetDiv.setAttribute('type', likeObj[index].type);
        targetDiv.setAttribute('linkUrl', likeObj[index].url);

        targetDiv.onclick = function() {
            this.lastChild.style.color = '#8494a8';
            var type = this.getAttribute('type');
            switch(type) {
                case 'doc':
                    ifeng.jump('doc', this.getAttribute('linkUrl'),"","recommend_slide");
                    break;
                case 'slide':
                    ifeng.jump('slide', this.getAttribute('linkUrl'),"","recommend_slide");
                    break;
                case 'web':
                    ifeng.jump('webfull', this.getAttribute('linkUrl'),"","recommend_slide");
                    break;
                default:
                    ifeng.jump('webfull', this.getAttribute('linkUrl'),"","recommend_slide");
            }
        };
    }
    document.getElementById('content-like-title').style.display = 'block';
    document.getElementById('content-like').style.display = 'block';

    var imgWidth = document.getElementById('news-title-left-img-like').offsetWidth;
    var contentWidth = document.getElementById('news-title-content-like').offsetWidth;
    var lineWidth = SCREEN_WIDTH-contentWidth-imgWidth-blank;
    document.getElementById('news-title-line-like').style.width= lineWidth+'px';
}

//初始化相关阅读的图集
function initReadSlideData(item) {
    var length = 0;
    var content = '';
    if(!item.thumbnail){
        length = item.style.images.length;
        content = '<div type="' + item.type + '" linkUrl="' + item.link.url + '" class="recommend-container"><div class="read-content-side-title"><span>' + item.title + '</span></div><br/>';
        var imageWidth = ((IMAGE_PLACEHOLDER_WIDTH-30)/3);
        var imageHeight = Math.round(imageWidth*55/81);
        for(var index=0,length = 2;index<=length;index++) {
            content += '<div class="read-item"><img src="'+(loadMode==1?"album_no_img.JPG":"album_default.JPG")+'" width="'+imageWidth+'" height="'+
                imageHeight+'" readImgSrc="'+item.style.images[index]+'"/></div>';

        }
        content += '</div>';
    }else{
        content+= '<div type="' + item.type + '" linkUrl="' + item.link.url + '" class="recommend-container"><div class="recommend-left"><img src="' + (loadMode == 1 ? "list_no_img.JPG" : "list_default.jpg") + '" readImgSrc="' +
            item.thumbnail + '"/></div><div class="recommend-right"><span>' + item.title + '</span><br/><img  src="channel_list_new_photo.png" width="11" height="10" style="padding-left:1.5px"/></div></div>';
    }

    return content;

}

// 显示相关新闻
function initRelativeNews() {

    // 数据判断
    var relationData = datas.getRelationsData();
    if (!relationData
        || Object.prototype.toString.call(relationData) !== '[object String]') {
        return false;
    }
    var relativeNewsData = JSON.parse(relationData),list = document.getElementById('news-list'),content='';

    //组装相关新闻数据
    if (relativeNewsData && relativeNewsData.length) {
        for(var i = relativeNewsData.length-1 ; i > -1 ; i-- ){
            if(relativeNewsData[i].src){
                var relativeNewsSrc = '<li link-url="'+relativeNewsData[i].url+
                    '" type="'+relativeNewsData[i].type+'" class="relative" url="'+relativeNewsData[i].url+
                    '">'+relativeNewsData[i].title+'&nbsp'+
                    '<img  icon="'+relativeNewsData[i].src+'" class="icon-image" src="'+relativeNewsData[i].src+'"/>'+'</li>';
            }else{
                var relativeNewsSrc = '<li link-url="'+relativeNewsData[i].url+
                    '" type="'+relativeNewsData[i].type+'" class="relative" url="'+relativeNewsData[i].url+
                    '">'+relativeNewsData[i].title+'&nbsp'+'</li>';
            }
            content = relativeNewsSrc + content;
        }
    }
    list.innerHTML = content;

    var relativeEls = list.getElementsByClassName('relative');

    // 相关新闻点击跳转
    for(var i = 0 ; i < relativeEls.length ; i++){
        relativeEls[i].onclick = function() {
            var type = this.getAttribute('type');
            if(type == 'slide' ){
                ifeng.jump('slide', this.getAttribute('link-url'),"","relative_news");
            }else {
                ifeng.jump('doc', this.getAttribute('link-url'),"","relative_news");
            }
            this.style.color = '#8494a8';
            //     this.style.backgroundImage = 'url(channel_list_divider.png),url(relation_dot_dark.png )';
            var images = this.getElementsByClassName('icon-image');
            if(images && images[0]){
                var image =  images[0].getAttribute('icon');
                if(image){
                    images[0].setAttribute('src','dark_'+image);
                }
            }
        };
    }

    document.getElementById('relativeNewsPanel').style.display = 'block';
    display|=1;



    var imgWidth = document.getElementById('news-title-left-img').offsetWidth;
    var contentWidth = document.getElementById('news-title-content').offsetWidth;
    var lineWidth = SCREEN_WIDTH-contentWidth-imgWidth-blank;
    document.getElementById('news-title-line').style.width= lineWidth+'px';
}


//根据指定字号计算字符所占宽度
function textSize(text) {
    var span = document.createElement("span");
    var result = {};
    result.width = span.offsetWidth;
    result.height = span.offsetWidth;
    span.style.visibility = "hidden";
    span.className = 'adv';
    document.body.appendChild(span);
    if (typeof span.textContent != "undefined")
        span.textContent = text;
    else span.innerText = text;
    result.width = span.offsetWidth - result.width;
    result.height = span.offsetHeight - result.height;
    span.parentNode.removeChild(span);
    return result;
}

// 底部空行
function bottomDisplay() {
    document.getElementById('bottom-space').style.display = 'block';
}

// 初始化文字链广告
function initAdv01(advData) {
    var advJson, advEl, itemEl, ITEM_FONT_SIZE = 20, itemFontAmount, doubleByteChars;
    ITEM_FONT_SIZE = textSize("凤").width // detail_page.html 中定义文字链广告字号大小为18px
    if (!advData
        || Object.prototype.toString.call(advData) !== '[object String]') {
        return false;
    }
    advEl = document.getElementById('adv01');
    itemEl = document.getElementById('advItem01');
    try {
        //java中encode会将空格替换成+号，所以js在decode的时候需要先将+替换成空格
        try {
            advData = decodeURIComponent(advData.replace(/\+/g,'%20'));
        }catch(e) {}
        advJson = JSON.parse(advData);
        itemFontAmount = Math.floor(IMAGE_PLACEHOLDER_WIDTH / ITEM_FONT_SIZE);
        doubleByteChars = advJson.text.match(/[^\x00-\xff]/ig);
//		console.log('adv:--- text=' + advJson.text + 'ITEM_FONT_SIZE=' + ITEM_FONT_SIZE + ', SCREEN_WIDTH=' + SCREEN_WIDTH + ', IMAGE_PLACEHOLDER_WIDTH=' + IMAGE_PLACEHOLDER_WIDTH + ', itemFontAmount=' + itemFontAmount + ', doubleByteChars=' + doubleByteChars);
        if (doubleByteChars && doubleByteChars.length) {
            itemFontAmount = Math.min(doubleByteChars.length, itemFontAmount) +
                2 * Math.max((itemFontAmount - doubleByteChars.length), 0);
        }

        itemEl.innerHTML = advJson.text.substr(0, itemFontAmount);
        var ad_source = advJson.adSource;
        if(ad_source && ad_source == "1") {
            var spread_tag = document.getElementById('ad_spread_1');
            spread_tag.innerText = "广告";
        }

        document.getElementById('relativeNewsPanel').style.background = 'none';
        advEl.style.display = 'block';
        document.getElementById('adv_wrapper').style.display = 'block';
        advEl.onclick = function(e) {
            ifeng.jump(advJson.adAction.type, advJson.adAction.url,advJson.text,"adv01");
        };
        bottomDisplay();
        isLoadAdv01 = true;
    } catch (e) {
        sendWebLog('initAdv01 Illegal json in adv data', decodeURIComponent(advData));
        console.log('Illegal json in adv data');
    }
}

// 初始新增化文字链广告
function initAdv02(advData) {
    var advJson, advEl, itemEl, ITEM_FONT_SIZE = 20, itemFontAmount, doubleByteChars;
    ITEM_FONT_SIZE = textSize("凤").width // detail_page.html 中定义文字链广告字号大小为18px
    if (!advData
        || Object.prototype.toString.call(advData) !== '[object String]') {
        return false;
    }
    advEl = document.getElementById('adv02');
    itemEl = document.getElementById('advItem02');
    try {
        if(!isLoadAdv01) {
            advEl.style.backgroundImage='url(adv_spinner.png)';
            advEl.style.backgroundPosition = 'top left';
            advEl.style.backgroundRepeat = 'repeat-x';
            advEl.style.paddingTop = '7px';
        }
        //java中encode会将空格替换成+号，所以js在decode的时候需要先将+替换成空格
        try {
            advData = decodeURIComponent(advData.replace(/\+/g,'%20'));
        }catch(e) {}
        advJson = JSON.parse(advData);
        itemFontAmount = Math.floor(IMAGE_PLACEHOLDER_WIDTH / ITEM_FONT_SIZE);
        doubleByteChars = advJson.text.match(/[^\x00-\xff]/ig);
//		console.log('adv:--- text=' + advJson.text + 'ITEM_FONT_SIZE=' + ITEM_FONT_SIZE + ', SCREEN_WIDTH=' + SCREEN_WIDTH + ', IMAGE_PLACEHOLDER_WIDTH=' + IMAGE_PLACEHOLDER_WIDTH + ', itemFontAmount=' + itemFontAmount + ', doubleByteChars=' + doubleByteChars);
        if (doubleByteChars && doubleByteChars.length) {
            itemFontAmount = Math.min(doubleByteChars.length, itemFontAmount) +
                2 * Math.max((itemFontAmount - doubleByteChars.length), 0);
        }

        itemEl.innerHTML = advJson.text.substr(0, itemFontAmount);
        var ad_source = advJson.adSource;
        if(ad_source && ad_source == "1") {
            var spread_tag = document.getElementById('ad_spread_2');
            spread_tag.innerText = "广告";
        }
        document.getElementById('relativeNewsPanel').style.background = 'none';
        advEl.style.display = 'block';
        document.getElementById('adv_wrapper').style.display = 'block';
        advEl.onclick = function(e) {
            ifeng.jump(advJson.adAction.type, advJson.adAction.url,advJson.text,"adv02");
        };
        bottomDisplay();
    } catch (e) {
        sendWebLog('initAdv02 Illegal json in adv data', decodeURIComponent(advData));
        console.log('Illegal json in adv data');
    }
}

//作者和责任编辑
function initEditorCode(author,editorCode) {

    var editor = document.getElementById('editor');
    if((!author||author.length<1)&&(!editorCode || editorCode.length < 1)) {
        editor.style.display = 'none';
        return false;
    }
    var container = document.getElementById('ifeng-article');
    container.style.paddingBottom = '0px';
    var authorText = '';
    if(author&&author.length>1){
        authorText = '作者: '+author;
    }

    var editorCodeText = '';
    if(editorCode || editorCode.length > 1){
        editorCodeText = '责任编辑: '+editorCode;
    }
    editor.style.display = 'block';
    editor.innerHTML =authorText+'&emsp;'+editorCodeText;

    topFlag = 1;
    document.getElementById('insert-news').style.paddingBottom = "0px";
}

//初始化顶部大图
function initTopBanner(datas) {
    try {
        var imgPath = datas.getBtl().getPic();
        if (!imgPath||imgPath.length==0) {
            return false;
        }
        var topEl = document.getElementById('top-banner');
        topEl.style.height = topEl.style.minHeight = Math.round(SCREEN_WIDTH
            * TOP_BANNER_SLOPE)
            + 'px';
        topEl.setAttribute('topElSrc',imgPath);
        topEl.style.display = 'block';
        topEl.innerHTML = '<span class="load-message">正在载入...</span>';
        Ground.loadImageDirectly(imgPath, null,
            loadImageSuccessInterceptor(topEl),
            loadImageFailInterceptor(topEl, imgPath), 'false');

        topEl.onclick = function() {
            var index, src, isLoaded, loadState;
            index = parseInt(this.getAttribute('index'));
            src = this.getAttribute('topElSrc');
            isLoaded = (this.className).indexOf('loaded') > -1;
            loadState = this.getAttribute('loadState');

            if(!isLoaded) {
                if(loadState=='loadFail'){
                    //如果没有网络连接，直接提示无网络
                    if(ifeng.checkNetWorkState() == 0) {
                        return;
                    }
                    if(loadMode == 1 || offlineMode) {
                        this.style.backgroundImage = 'url('+nophoto_arrays[1]+')';
                    } else {
                        this.innerHTML = '<span class="load-message">正在载入...</span>';
                    }
                    this.setAttribute('loadState','loading');
                    Ground.loadImageDirectly(imgPath, null,
                        loadImageSuccessInterceptor(topEl),
                        loadImageFailInterceptor(topEl, imgPath), 'forceLoad');
                }
            }
        };
    } catch (e) {
    }
}

//初始化banner广告
function initAdv2(data) {
    if (!data || Object.prototype.toString.call(data) !== '[object String]') {
        return false;
    }
    var advEl = document.getElementById('adv2'), advJson;
    try {
        advJson = JSON.parse(data);

        if(typeof(advJson.imgPath) == "undefined" || advJson.imgPath.length<=0) {
            document.getElementById('ad-photo-parent').style.display="none";
            return;
        }
        advEl.style.width = SCREEN_WIDTH-24;
        if(advJson.imageHeight && advJson.imageWidth) {
            advEl.style.height = advEl.style.minHeight = Math.round((SCREEN_WIDTH-24)
                * advJson.imageHeight/advJson.imageWidth)+ 'px';
        } else {
            return;
        }

        advEl.style.backgroundImage = 'url(' + advJson.imgPath + ')';
        advEl.style.display = 'block';
        advEl.onclick = function(e) {
            ifeng.jump(advJson.type, advJson.url,"","banner");
        };

        bottomDisplay();
    } catch (e) {
        sendWebLog('initAdv2 Illegal json in adv data', decodeURIComponent(data));
    }
}
function offsetTop( elements ){
    var top = elements.offsetTop;
    var parent = elements.offsetParent;
    while( parent != null ){
        top += parent.offsetTop;
        parent = parent.offsetParent;
    };
    return top;
};

//初始化订阅推荐
function initSubscribe(datas) {
    var wrapper = document.getElementById('sub-wrapper');
    try {
        if(!datas.getSubscribe() || !datas.getSubscribe().getLogo() ||
            !datas.getSubscribe().getCatename() || !datas.getSubscribe().getCateid() ||
            !datas.getSubscribe().getDescription()){
            wrapper.style.display = 'none';
            if(claimer) {
                document.getElementById("disclamer_wrapper").style.marginBottom = "20px";
            }
            return false;
        }
        Ground.isSubscribe(subSuccess(),"");
        var imgPath = datas.getSubscribe().getLogo();
        if (imgPath.length==0) {
            wrapper.style.display = 'none';
            return false;
        }
        wrapper.onclick = function(event) {
            ifeng.gotoSubscribe();
            event.stopPropagation();
        }
        var subIconEl = document.getElementById('subscription-icon');
        var subTitle = document.getElementById('subscription_title');
        var subContent = document.getElementById('subscription_content');
        var subButton = document.getElementById('subscription-button');
        subTitle.innerHTML = datas.getSubscribe().getCatename();
        subContent.innerHTML = datas.getSubscribe().getDescription();
        wrapper.style.display = 'block';
        subButton.onclick = function(event) {
            Ground.addSubscribe(subSuccess(),"");
            event.stopPropagation();
        };
        Ground.loadImageDirectly(imgPath, null,
            loadImageSuccessInterceptor(subIconEl),
            loadSubscriptImageFailInterceptor(subIconEl,imgPath), 'forceLoad');
    } catch (e) {
    }
}

function initSource(datas){
    try{
    var wrapper = document.getElementById('time-and-source-panel');
        wrapper.onclick = function(event) {
            ifeng.gotoSubscribe();
            event.stopPropagation();
        }
        var iconWrap = document.getElementById('cir');
        var icon = document.getElementById('source_icon');
        var source = document.getElementById('source');
        var time = document.getElementById('time');
        var subButton = document.getElementById('subscribe');
        var catesource = document.getElementById('catesource');
        var line = document.getElementById('verticalline');
        var catesource_str,type,cateName,imgPath;
        if(datas.getSubscribe()){
            catesource_str = datas.getSubscribe().getCateSource();
            type = datas.getSubscribe().getType();
            cateName = datas.getSubscribe().getCatename();
            imgPath = datas.getSubscribe().getLogo();
        }

        if(catesource_str && typeof(catesource_str)!="undefined" && catesource_str!=0){
            catesource.style.display = "block";
            line.style.display = "block";
            catesource.innerHTML = catesource_str;
            line.innerHTML = "|";
        }else{
            catesource.style.display = "none";
            line.style.display = "none";
        }

        if(typeof(type)!="undefined"){
         subButton.style.display = "block";
         Ground.isSubscribe(subSourceSuccess(),"");
        }else{
         subButton.style.display = "none";
        }
        if(typeof(cateName)!="undefined"){
           source.innerHTML = cateName;
        }else{
            source.style.display = "none";
        }

        time.innerHTML = datas.getUpdateTimeForDetail();

        wrapper.style.display = 'block';
        icon.style.display = 'block';
        subButton.onclick = function(event) {
            Ground.addSubscribe(subSourceSuccess(),"");
            event.stopPropagation();
        };

        if(typeof(imgPath)!="undefined" && imgPath!=0){
        icon.style.display = 'block';
                Ground.loadImageDirectly(imgPath, null,
                    loadImageSuccessInterceptor(icon),
                    loadSubscriptImageFailInterceptor(icon,imgPath), 'forceLoad');
        }else if(cateName && typeof(cateName)!="undefined"){
                icon.style.display = 'block';
                ifeng.setLogo(cateName);
        }else{
            icon.style.display = "none";
            iconWrap.style.display = "none";
            time.style.left = "0px";
        }


    } catch (e) {
    }
}

function initSubState(){
  return function(subState){
    var subscribeEl = document.getElementById('subscribe');
    if(subState){
      subscribeEl.setAttribute("src","news_sub_added.png");
    }else{
      subscribeEl.setAttribute("src","news_sub_add.png");
    }
  }
}
function subSuccess() {
    return function(subState){
        var subButton = document.getElementById('subscription-button');
        if(subState){
            subButton.setAttribute("src", "sub_delete.png");
        }else{
            subButton.setAttribute("src", "sub_add.png");
        }
    };
}

function subSourceSuccess() {
    return function(subState){
        var subButton = document.getElementById('subscribe');
        if(subState){
            subButton.setAttribute("src", "delete_sub_detail.png");
        }else{
            subButton.setAttribute("src", "add_sub_detail.png");
        }
    };
}

// 显示评论内容
function initComment(commentData) {
    var commentEl, commentCountEl, container,
        commentJson, commentNum, commentList, commentListLen, commentListItem,
        commentListHtml = '';
    if (!commentData || Object.prototype.toString.call(commentData) !== '[object String]') {
        return false;
    }

    try {
        //java中encode会将空格替换成+号，所以js在decode的时候需要先将+替换成空格
        commentJson = JSON.parse(decodeURIComponent(commentData.replace(/\+/g,'%20')));

        commentNum = commentJson.join_count || 0;
        commentList = commentJson.comments.hottest;
        commentListLen = Math.min(commentList.length, 5); // 截取5条

        commentCountEl = document.getElementById('comment_count_num');
        commentCountEl.innerHTML = commentNum;

        if(commentListLen === 0) {
            return false;
        }

        commentEl = document.getElementById('comment');
        container = document.getElementById('comment_list');

        for(var i = 0; i < commentListLen; i++ ) {
            commentListItem = commentList[i];
            commentListItem.userFace = commentListItem.userFace?commentListItem.userFace:'';
            commentListHtml += '' +
                '<li class="comment-item">' +
                '<div class="comment-item-left">' +
                '<img src="default_ava.png" commentImageSrc="'+commentListItem.userFace+'" class="comment-item-ava"/>' +
                '</div>' +
                '<div class="comment-item-right">' +
                '<div class="comment-item-title">凤凰网' + commentListItem.ip_from + '网友：</div>' +
                '<div class="comment-item-content">' + commentListItem.comment_contents + '</div>' +
                '</div>' +
                '</li>';
        }
        container.innerHTML = commentListHtml;
        commentEl.style.display = 'block';
        setTimeout(function() {
            //加载评论头像
            var imgs = container.getElementsByTagName('img');
            for(var i=0;i<imgs.length;i++) {
                var commentImageDom = imgs[i],commentImageSrc = commentImageDom.getAttribute('commentImageSrc');
                if(commentImageSrc) {
                    Ground.loadImageDirectly(commentImageSrc, null,
                        loadImageSuccessInterceptor(commentImageDom, i),
                        loadImageFailInterceptor(commentImageDom, commentImageDom.getAttribute('commentImageSrc')), 'false');
                }
            }
        }, 100);

    }
    catch (e) {
        sendWebLog('Illegal json in comment data', decodeURIComponent(commentData))
        console.log('Illegal json in comment data ');
    }
}


// 修复p内套多个img 以及 p内有small标签
function formatText(text) {
    var fragment = document.createElement('div');
    fragment.innerHTML = text;
    var eles = Array.prototype.slice.call(fragment.getElementsByTagName('p'));
    for ( var i = 0; i < eles.length; i++) {
        var container = eles[i],
            imgs = Array.prototype.slice.call(container.getElementsByTagName('ifengimg'));

        if(container.getElementsByTagName('small').length === 1) {
            container.className += ' img-note';
        }

        if (imgs.length < 2) {
            continue;
        }
        var frag = document.createDocumentFragment();
        for ( var j = 0; j < imgs.length; j++) {
            var p = document.createElement('p');
            p.appendChild(imgs[j]);
            frag.appendChild(p);
        }
        try{
        fragment.replaceChild(frag, container);
        }catch(e){
        }
    }
    return fragment.innerHTML;
}

//得到图集的宽和高 如果有宽和高的话，需要重新设置min-height为返回的高
function getHeightRule() {
    var extraRule = '';
    if(arguments[0].thumbnailSize) {
        var width = arguments[0].thumbnailSize.width, height = arguments[0].thumbnailSize.height;
        if (width && height) {
            var minheight = 'min-height:'+cropper.getResult(width, height).height+'px';
            extraRule = 'style="'+minheight+'"';
        }
    }
    return extraRule;
}

function getCenterAdHeightRule(item){
    var extraRule = '';
        if(item.imageWidth && item.imageHeight) {
            var width = item.imageWidth, height = item.imageHeight;
            if (width && height) {
                var minheight = 'min-height:'+cropper.getResult(width, height).height+'px';
                extraRule = 'style="'+minheight+'"';
            }
        }
        return extraRule;
}

function getVideoRule() {
    return 'style="min-height:'+IMAGE_PLACEHOLDER_WIDTH*VIDEO_SLOP+'px"';
}


function getContentPosition(content,str) {
    var index=0,list = [];
    while((index=content.indexOf(str,index))!=-1) {
        list.push(index++);
    }
    return list;
}

function insertStr(source,str,position) {
    var str_sta = source.substring(0, position);
    var str_end = source.substring(position);
    return str_sta+str+str_end;
}

// 处理 图集,视频占位符
function handle_img_position(content,flag_p,item_length,getItem) {
    var list = getContentPosition(content, flag_p),
        length = list.length,
        flag_p_length = flag_p.length;
    if(length>0) {
        var i,j,temp_sum,min_length = Math.min(length, item_length);
        content = content.replace(new RegExp(flag_p,"gm"),"");
        for(i=0;i<length;i++) {
            list[i]-=flag_p_length*i;
        }
        for(j=0,temp_sum=0;j<min_length;j++) {
            var item_str = getItem(j);
            if (!item_str || Object.prototype.toString.call(item_str) !== '[object String]') {
                continue;
            }
            content = insertStr(content, item_str, temp_sum+list[j]);
            temp_sum+=item_str.length;
        }
        if(length<item_length) {
            for(i=item_length-1; i>=j; i--) {
                var item_str = getItem(i);
                if (!item_str || Object.prototype.toString.call(item_str) !== '[object String]') {
                    continue;
                }
                content = item_str + content;
            }
        }
    } else {
        for(var i = item_length-1; i > -1; i--) {
            var item_str = getItem(i);
            if (!item_str || Object.prototype.toString.call(item_str) !== '[object String]') {
                continue;
            }
            content = item_str + content;
        }
    }

    return content;
}

// 处理调查占位符
function handle_survey_position(content,flag_p,item_length,getItem) {
    var list = getContentPosition(content, flag_p),
        length = list.length,
        flag_p_length = flag_p.length;
    if(length>0) {
        var i,j,temp_sum,min_length = Math.min(length, item_length);
        content = content.replace(new RegExp(flag_p,"gm"),"");
        for(i=0;i<length;i++) {
            list[i]-=flag_p_length*i;
        }
        for(j=0,temp_sum=0;j<min_length;j++) {
            var item_str = getItem(j);
            if (!item_str || Object.prototype.toString.call(item_str) !== '[object String]') {
                continue;
            }
            content = insertStr(content, item_str, temp_sum+list[j]);
            temp_sum+=item_str.length;
        }
    }

    return content;
}
//处理广告占位符
function handle_advert_position(content,flag_p,getItem) {
    var list = getContentPosition(content, flag_p),
        length = list.length,
        flag_p_length = flag_p.length;
    if(length>0) {
        var i,j,temp_sum;
        content = content.replace(new RegExp(flag_p,"gm"),"");
        for(i=0;i<length;i++) {
            list[i]-=flag_p_length*i;
        }
        for(j=0,temp_sum=0;j<length;j++) {
            var item_str = getItem();
            if (!item_str || Object.prototype.toString.call(item_str) !== '[object String]') {
                continue;
            }
            content = insertStr(content, item_str, temp_sum+list[j]);
            temp_sum+=item_str.length;
        }
    }
    return content;
}


// 显示正文 处理图片显示底图 准备加载
function preprocessImage(content, container) {
    var loadMessage = '';
    if(loadMode!=1) {
        loadMessage = '<span class="load-message">正在载入...</span>';
    }

    var imgInfo = datas.getImgJson();
    content = processImage(cropper,IMAGE_PLACEHOLDER_HEIGHT,content, container, imgInfo);

    //处理自媒体中的商品
    var goodsData = datas.getDocGoodsJson();
    try {
         var allGoodsJson = JSON.parse(goodsData);
         for (var goodkey in allGoodsJson) {
              var flag = GOOD_P_PREFIX + goodkey + GOOD_P_SUFFIX;
              var list = getContentPosition(content, flag);
              if (list.size <= 0) {
                  continue;
              }
              var goodsArray = allGoodsJson[goodkey];
              var goodsCount  = goodsArray.length;
              var itemHtml = '<div class="addiv">';
              for (i=0; i< goodsCount; i++) {
                  var good = goodsArray[i];
                  itemHtml += getZmtGoodContentByType(good);
              }
              itemHtml += '</div>';
              content = handle_zmt_goods_position(content, flag, itemHtml);
         }
    }catch(e){
       console.log("error:"+e);
    };

    // 显示中心广告
    var advertData = datas.getArticleAdDataJson();
    if(advertData && Object.prototype.toString.call(advertData) == '[object String]'){
    var adBean = JSON.parse(advertData);
    content = handle_advert_position(content, center_ad_p,
        function() {
            if (adBean.type == 'advert') {
             var str = '<div class = "advertdiv" id="advertdiv""></div>';
                if(adBean.link.url){

                     str = '<div class = "advertdiv" id = "advertdiv" style="position:relative;display:block;padding-left:60px;"'
                            +getCenterAdHeightRule(adBean)
                            +'><img id="advert" style="position:relative;width:100%;" class="advert" '
                            +' advertsrc="' + adBean.thumbnail + '" src="'
                            + adBean.link.url + '"/>';
                 }
                 var addTagHtml ='<img id="ad-close" src="ad_detail_clolse.png" '
                    +'style="position:absolute;width:24px;height:24px;top:5px;right:7px;z-index:100"/>'
                    +'<div id="ad_tag" class="adv-tag">&nbsp;广告&nbsp;</div></div>';
                return str + addTagHtml;
            }
        return null;
        });
    }else{
         content = handle_advert_position(content, center_ad_p,
                function() {
                    return '<div class = "advertdiv" id="advertdiv""></div>';
                });
    }

    // 显示slide封面
    var slideData = datas.getExtSlidesJson();
    if(slideData
        && Object.prototype.toString.call(slideData) == '[object String]'){
        var extensionsData = JSON.parse(slideData);
        content = handle_img_position(content, slide_p, extensionsData.length,
            function(i) {
                if (extensionsData[i].type == 'slide') {
                    if(extensionsData[i].title) {
                        return '<p style="margin-top:26px;margin-bottom:11px;" class="slide" '+getHeightRule(extensionsData[i])+' slidesrc="'
                            + extensionsData[i].thumbnailpic
                            + '" src="'
                            + extensionsData[i].url + '">'+loadMessage+'</p><div><small class="slide-small" style="line-height:23px;">'+extensionsData[i].title+'</small></div>';
                    } else {
                        return '<p style="margin-top:26px;margin-bottom:26px;" class="slide" '+getHeightRule(extensionsData[i])+' slidesrc="'
                            + extensionsData[i].thumbnailpic
                            + '" src="'
                            + extensionsData[i].url + '">'+loadMessage+'</p>';
                    }
                }
                return null;
            });
    }


    // 显示video封面
    var videoData = datas.getVideoJson();
    if(videoData && Object.prototype.toString.call(videoData) == '[object String]'){
        var videos = JSON.parse(videoData);
        var isInstalled = ifeng.isIfengVideoAppInstalled();
        content = handle_img_position(content, video_p, videos.length,
            function(i) {
                var videoItemContent = "";
                if(videos[i].title) {
                    videoItemContent += '<div class="video" '+getVideoRule(videos[i])+' videoType=normal imgsrc="'+videos[i].thumbnail+'" normalSrc="'+videos[i].video.Normal.src+'" HDSrc="'+videos[i].video.HD.src+'" duration="'+videos[i].duration+'" guid="'+videos[i].guid+'" staticId="'+videos[i].staticId+'" columnId="'+videos[i].columnId+'">'+loadMessage+'</div><div style="margin-top:11px;"><small class="slide-small" style="line-height:23px;">'+videos[i].title+'</small></div>';
                }else{
                    videoItemContent += '<div  class="video" '+getVideoRule(videos[i])+' videoType=normal imgsrc="'+videos[i].thumbnail+'" normalSrc="'+videos[i].video.Normal.src+'" HDSrc="'+videos[i].video.HD.src+'" duration="'+videos[i].duration+'" guid="'+videos[i].guid+'" staticId="'+videos[i].staticId+'" columnId="'+videos[i].columnId+'">'+loadMessage+'</div>';
                }
//                var mVideoDesc = videos[i].videoAppDesc;
//                if(isInstalled){
//                    mVideoDesc = '打开';
//                }else{
//                    mVideoDesc = '下载';
//                }
//                mVideoDesc += '凤凰视频客户端';
//                videoItemContent += '<div class="ifeng_video_bottom"><div class="video_button" guid='+videos[i].guid+'><span class="video_button_title">'+mVideoDesc+'</span></div></div></p>';
                if(isInstalled){
                        videoItemContent +='<div id="video-bottom" class="video-bottom" guid='+videos[i].guid+'>'+
                                                           	'<img src="video_logo.png" class="video-logo" />'+
                                                           	'<div style="float:left;padding-left:8px;margin-top:2px;">'+
                                                           	    '<div style="font-size:10px;color: #1a1a1a">打开凤凰视频客户端</div>'+
                                                           		'<div style="font-size:14px;color: #1a1a1a;font-weight:bold">提升3倍流畅度</div>'+
                                                           	'</div>'+
                                                           	'<img src="video_open.png" class="video-open"/>'+
                                                           	'<div style="clear:both"></div>'+
                                                           '</div>';
                }else{
                     videoItemContent +='<div id="video-bottom" class="video-bottom" guid='+videos[i].guid+'>'+
                                                        	'<img src="video_logo.png" class="video-logo" />'+
                                                        	'<div style="float:left;padding-left:8px;margin-top:2px;">'+
                                                        	    '<div style="font-size:10px;color: #1a1a1a">下载凤凰视频客户端</div>'+
                                                        		'<div style="font-size:14px;color: #1a1a1a;font-weight:bold">提升3倍流畅度</div>'+
                                                        	'</div>'+
                                                        	'<img src="video_download.png" class="video-open"/>'+
                                                        	'<div style="clear:both"></div>'+
                                                        '</div>';
                }



               return videoItemContent;
            });
    }
    // 显示视频直播liveStream封面
    var liveStreamData = datas.getLiveStreamJson();

    if(liveStreamData && Object.prototype.toString.call(liveStreamData) == '[object String]'){
        var liveStream = JSON.parse(liveStreamData);
        var	liveStreamStr  = '';
        if(liveStream.title) {
            liveStreamStr = '<p style="margin-top:26px;" class="video_parent"><div class="video" '+getVideoRule(liveStream)+'videoType=liveStream duration=0 imgsrc="'+liveStream.thumbnail+'" normalSrc="'+liveStream.android+'" HDSrc="'+liveStream.ios+'">'+loadMessage+'</div><div style="margin-top:11px;"><small class="slide-small" style="line-height:23px;">'+liveStream.title+'</small></div></p>';
        } else {
            liveStreamStr = '<p style="margin-top:26px;" class="video_parent"><div style="margin-bottom:30px;" class="video" '+getVideoRule(liveStream)+'videoType=liveStream duration=0 imgsrc="'+liveStream.thumbnail+'" normalSrc="'+liveStream.android+'" HDSrc="'+liveStream.ios+'">'+loadMessage+'</div></p>';
        }
        content = liveStreamStr + content;
    }

    //加载音频
    var audioListStr = datas.getAudioJson();
    if(audioListStr && Object.prototype.toString.call(videoData) == '[object String]'){
        var audioList = JSON.parse(audioListStr);
         console.info('audioList'+audioList);
         content = handle_survey_position(content,audio_p,audioList.length,
                    function(i){
                       var audioItemContent ='<div class="audio" id="audio" title="'+audioList[i].title+'" desc="'+audioList[i].audioAppDesc+'" duration="'+audioList[i].duration+'" srcNor="'+audioList[i].audio.Normal.src+'" srcHD="'+audioList[i].audio.HD.src+'" guid="'+audioList[i].guid+ '" columnId="'+videos[i].columnId+'">'+
                                                            '<img src="detail_audio_play.png" class="audio_img" />'+
		                                                    '<div class="audio_info" id="audio_info">'+
		                                                    	'<div class="audio_title" id="audio_title">'+audioList[i].title+'</div>'+
		                                                    	'<div class="audio_desc" id="audio_desc">'+audioList[i].audioAppDesc+'</div>'+
		                                                    '</div>'+
		                                                    '<div class="audio_time" id="audio_time">'+audioList[i].duration+'</div>'+
		                                                    '<div style="clear:both"></div>'+
                                                         '</div>';
                       return audioItemContent;
                    });
    }

    // 核心提示
    var tip = datas.getIntroduction();
    if(tip && Object.prototype.toString.call(tip) == '[object String]'){
        var fragment = document.createElement('div');
        fragment.innerHTML = content;
        var childs = fragment.childNodes;
        if(childs && childs.length>0) {
            var tipContent = "";
            if(childs[0].className == "video_parent"
                || childs[0].className == "slide"
                ||childs[0].className == "placeholder") {
                tipContent = '<div class="tip-news-wrapper">'+tip+'</div>';
            } else {
                tipContent = '<div class="tip-news-wrapper-se">'+tip+'</div><div class="tip-divider-wrapper"><div class="tip-divider">&nbsp;</div></div>';
            }
            content = tipContent+content;
        }
    } else {
        document.getElementById("time-and-source-panel").style.marginBottom = "10px";
        // 分割线
        //   var divider = '<div class="content-divider" id="content-divider"></div>';
        //   content = divider + content;
    }
    content =  buildMulSurvey(content);
    // 显示正文
    container.innerHTML = content;
    var eles = Array.prototype.slice.call(container.getElementsByTagName('p'));
    if(eles.length==0){
        container.innerHTML = '<p>'+container.innerHTML+'</p>';
    }

    // 隐藏loading,可以视情况延时调用
    if(!SCREEN_WIDTH){
        SCREEN_WIDTH = '0';
    }
    ifeng.hideLoadingMask(SCREEN_WIDTH);
    // 启动加载图片
    setTimeout(loadImages, 200);

}

//获取元素的纵坐标（相对于窗口）
function getTop(e){
    var offset=e.offsetTop;
    if(e.offsetParent!=null) offset+=getTop(e.offsetParent);
    return offset;
}
//获取元素的横坐标（相对于窗口）
function getLeft(e){
    var offset=e.offsetLeft;
    if(e.offsetParent!=null) offset+=getLeft(e.offsetParent);
    return offset;
}

function matchImageUrl(imgUrl) {
    var regx="/[\/_]w(\d{1,4})_h(\d{1,4})/i";
    var rs=regx.exec(imgUrl);
    var rs1=regx.exec(imgUrl);
}

function formatChild(note){
    var nodes = note.childNodes;
    var canBreak = 0;
    for(var i=nodes.length-1;i>=0;i--){
        if(nodes[i].nodeType==1&&nodes[i].nodeName=="P"&&nodes[i].getAttribute("class")!=="placeholder"){
            var cNodes = nodes[i].childNodes;
            for(var j=0;j<cNodes.length;j++){
                if(cNodes[j].nodeType==1){
                    if(j==cNodes.length-1&&(cNodes[j].nodeName=="STRONG"||cNodes[j].nodeName=="SPAN")){
                        if(cNodes[j].childNodes.length>0&&cNodes[j].childNodes[0].nodeName!=="SMALL"){
//							var inner = cNodes[j].innerHTML;
//							var index = inner.lastIndexOf('<');
//							if(index == -1){
//								cNodes[j].innerHTML = inner.substr(0,inner.length-1) + '<span style = "white-space: nowrap;">'+inner.substr(inner.length-1,inner.length)+'</span>';
//							}else{
//								cNodes[j].innerHTML = inner.substr(0,index-1) + '<span style = "white-space: nowrap;">'+inner.substr(index-1,index)+'</span>';
//							}
                            if(!canBreak){
                                canBreak = 1;
                            }
                            break;
                        }
                    }
                }else if(cNodes[j].nodeType==3){
                    var inner = cNodes[j].parentNode.innerHTML;
                    if(inner){
//						var index = inner.lastIndexOf('>');
//							if(index == inner.length-1){
//								var contentIndex = inner.lastIndexOf('<');
//								if(contentIndex !== -1&&contentIndex<index){
//									console.log(' index is : '+contentIndex);
//									var content = inner.substr(contentIndex-1, contentIndex)
//									console.log('content is : '+content + ' index is : '+contentIndex);
//									if(content.substr(0)=='>'){
//										cNodes[j].parentNode.innerHTML = inner.substr(0,contentIndex-1) + '<span style = "white-space: nowrap;">'+content+'</span>'+inner.substr(contentIndex,inner.length);
//									}
//								}else{
//									cNodes[j].parentNode.innerHTML = inner.substr(0,inner.length-1) + '<span style = "white-space: nowrap;">'+inner.substr(inner.length-1,inner.length)+'</span>';
//								}
//							}else{
//								cNodes[j].parentNode.innerHTML = inner.substr(0,inner.length-1) + '<span style = "white-space: nowrap;">'+inner.substr(inner.length-1,inner.length)+'</span>';
//							}
                        if(!canBreak){
                            canBreak = 1;
                        }
                        break;
                    }


                }
            }
        }
    }
    return note;

}

// 滚动加载图片
function loadImages() {
    if(document.getElementById('advertdiv')){
        ifeng.setCenterAdPosition(offsetTop(document.getElementById('advertdiv')));
    }
    var container = document.getElementById('content'),
        placeholders = Array.prototype.slice.call(container.getElementsByClassName('placeholder')),
        src, docId = datas.getDocumentId(),loadMessage = '<span class="load-message">正在载入...</span>';
    var VIEWPORT_HEIGHT = window.innerHeight || document.documentElement.clientHeight; // VIEWPORT_HEIGHT || document.body.clientHeight;
    if (VIEWPORT_HEIGHT < 300) {
        VIEWPORT_HEIGHT = 800; // 若获取高度不正确给默认高度800，可能的副作用是浏览正文时会预载更多的图片。
    }
//    console.log('window.innerHeight  '+window.innerHeight+', document.body.clientHeight  '+document.body.clientHeight+', VIEWPORT_HEIGHT  '+VIEWPORT_HEIGHT);
    var videoComponent = container.getElementsByClassName('video');

    var slideComponent = container.getElementsByClassName('slide');

    var advertComponent = container.getElementsByClassName('advert');

    var videoJumpComponent = container.getElementsByClassName('video-bottom');

    var tipContainer = document.getElementById('news-content');
    var tipPlaceHolders = Array.prototype.slice.call(tipContainer.getElementsByClassName('placeholder'))

    var telephoneComponent = container.getElementsByClassName('telephone');

    var goodComponent = container.getElementsByClassName('goodimg');
    var goodItemWapper = container.getElementsByClassName('wemedia_ad');

    if(placeholders && placeholders.length>=0 && tipPlaceHolders && tipPlaceHolders.length>0) {
         placeholders = placeholders.concat(tipPlaceHolders);
    }

    //加载视频图片
    for(var i = 0; i<videoComponent.length; i++) {
        var videoDom = videoComponent[i];
        var jumpDom = videoJumpComponent[i];
        imgQuene.push({
            ot: videoDom.offsetTop,
            dom: videoDom,
            src: videoDom.getAttribute('imgsrc')
        })
        videoDom.onclick = function() {
            index = parseInt(this.getAttribute('index'));
            src = this.getAttribute('imgsrc');
            isLoaded = (this.className).indexOf('loaded') > -1;
            loadState = this.getAttribute('loadState');
            if(loadState=='loadFail') {
                //如果没有网络连接，直接提示无网络
                if(ifeng.checkNetWorkState() == 0) {
                    return;
                }
                if(loadMode == 1 && !offlineMode) {
                    this.style.backgroundImage = 'url(video_loading.png),url()';
                } else {
                    handle_video_message(this, 1);
                }
                this.setAttribute('loadState','loading');
                Ground.loadImageDirectly(src, docId,
                    loadImageSuccessInterceptor(this),
                    loadImageFailInterceptor(this, src),'forceLoad');
            }
            ifeng.playVideo(window.devicePixelRatio*this.clientHeight,window.devicePixelRatio*getLeft(this), window.devicePixelRatio*getTop(this),this.getAttribute('normalSrc'),this.getAttribute('HDSrc'),this.getAttribute('videoType'),this.getAttribute('duration'),this.getAttribute('guid'),this.getAttribute('staticId'),this.getAttribute('columnId'));
        };

        /***
         * 打开凤凰视频app or 下载凤凰视频app。
         */
        if(jumpDom) {
            jumpDom.onclick = function() {
                var guid = this.getAttribute('guid');
                ifeng.jumpIfengVideoApp(guid);
            };
        }
    }

    if(telephoneComponent && telephoneComponent.length > 0){
        var telphoneLabel;
        for(var i = 0; i < telephoneComponent.length; i ++){
            telphoneLabel = telephoneComponent[i];
            telphoneLabel.onclick =  function(){
                //sendWebLog('text telephone', "you click : "+this.innerText);
                ifeng.makeTelephone(this.innerText);
            };
        }
    }
    //加载中心广告图片
    for(var i = 0; i < advertComponent.length; i++) {
            var advertDom = advertComponent[i];
            imgQuene.push({
                ot:  advertDom.offsetTop,
                dom: advertDom,
                src: advertDom.getAttribute('advertsrc')
            })
            document.getElementById('advertdiv').style.width = ifeng.getScreenWidth()-60 +'px';
            document.getElementById('advertdiv').style.height= Math.round((ifeng.getScreenWidth()-120) / BODY_AD_CENTER_RADIO)+'px';
            advertDom.onclick = function() {
                index = parseInt(this.getAttribute('index'));
                src = this.getAttribute('advertsrc');
                isLoaded = (this.className).indexOf('loaded') > -1;
                loadState = this.getAttribute('loadState');
                if(isLoaded) {
                    ifeng.centerAdClick();
                }  else {
                    if(loadState=='loadFail'){
                        //如果没有网络连接，直接提示无网络
                        if(ifeng.checkNetWorkState() == 0) {
                            return;
                        }
                        if(loadMode == 1 && !offlineMode) {
                            this.style.backgroundImage = 'url(slide_text.png),url(logo_loading.png)';
                            this.style.backgroundSize = '40px 22px,auto';
                        } else {
                            this.innerHTML = loadMessage;
                        }
                        this.setAttribute('loadState','loading');
                        Ground.loadImageDirectly(src, docId,
                            loadImageSuccessInterceptor(this),
                            loadImageFailInterceptor(this, src),'forceLoad');
                    }
                }
            };
        }

    //加载自媒体商品图片
    for(var i = 0; i < goodComponent.length; i++) {
            var goodDom = goodComponent[i];
            imgQuene.push({
                ot:  goodDom.offsetTop,
                dom: goodDom,
                src: goodDom.getAttribute('imgsrc')
            })
            goodDom.onclick = function() {
                index = parseInt(this.getAttribute('index'));
                src = this.getAttribute('imgsrc');
                isLoaded = (this.className).indexOf('loaded') > -1;
                loadState = this.getAttribute('loadState');
                if(isLoaded) {

                }  else {
                    if(loadState=='loadFail'){
                        //如果没有网络连接，直接提示无网络
                        if(ifeng.checkNetWorkState() == 0) {
                            return;
                        }
                        if(loadMode == 1 && !offlineMode) {
                            this.style.backgroundImage = 'url(slide_text.png),url(logo_loading.png)';
                            this.style.backgroundSize = '40px 22px,auto';
                        } else {
                            this.innerHTML = loadMessage;
                        }
                        this.setAttribute('loadState','loading');
                        Ground.loadImageDirectly(src, docId,
                            loadImageSuccessInterceptor(this),
                            loadImageFailInterceptor(this, src),'forceLoad');
                    }
                }
            };
        }

    //自媒体商品的点击事件
    for(var i = 0; i < goodItemWapper.length; i++) {
        var goodDom = goodItemWapper[i];
        goodDom.onclick = function() {
            type = this.getAttribute('goodlinktype');
            goodId = this.getAttribute('goodId');
            url = this.getAttribute('goodlinkurl');
            ifeng.goodClick(type, goodId, url);
       }
    }

    //加载图集图片
    for(var i = 0; i < slideComponent.length; i++) {
        var slideDom = slideComponent[i];
        imgQuene.push({
            ot:  slideDom.offsetTop,
            dom: slideDom,
            src: slideDom.getAttribute('slidesrc')
        })

        slideDom.onclick = function() {
            index = parseInt(this.getAttribute('index'));
            src = this.getAttribute('slidesrc');
            isLoaded = (this.className).indexOf('loaded') > -1;
            loadState = this.getAttribute('loadState');
            if(isLoaded) {
                ifeng.goToSlide(this.getAttribute('src'));
            }  else {
                if(loadState=='loadFail'){
                    //如果没有网络连接，直接提示无网络
                    if(ifeng.checkNetWorkState() == 0) {
                        return;
                    }
                    if(loadMode == 1 && !offlineMode) {
                        this.style.backgroundImage = 'url(slide_text.png),url(logo_loading.png)';
                        this.style.backgroundSize = '40px 22px,auto';
                    } else {
                        this.innerHTML = loadMessage;
                    }
                    this.setAttribute('loadState','loading');
                    Ground.loadImageDirectly(src, docId,
                        loadImageSuccessInterceptor(this),
                        loadImageFailInterceptor(this, src),'forceLoad');
                }
            }
        };
    }

    for ( var i = 0; i < placeholders.length; i++) {
        var imgDom = placeholders[i];
        src = imgDom.getAttribute('src');
//   console.log('img '+i+' offsetTop=' + imgDom.offsetTop);
        imgQuene.push({
            ot: imgDom.offsetTop,
            dom: imgDom,
            src: src
        })
        if(imgDom.getAttribute("sale_flag") == "1") {
            imgDom.style.borderLeft = "1px solid #f2f2f2";
            imgDom.style.borderRight = "1px solid #f2f2f2";
        }
        // 点击判断加载状态 执行重新加载 或 显示幻灯
        imgDom.onclick = function(i) {
            var index, src, isLoaded, loadState;
            index = parseInt(this.getAttribute('index'));
            src = this.getAttribute('src');
            isLoaded = (this.className).indexOf('loaded') > -1;
            loadState = this.getAttribute('loadState');
            if(isLoaded) {
                if(this.getAttribute("sale_flag") != "1") {
                    ifeng.popupLightbox(srcs,index);
                }
            } else {
                if(loadState=='loadFail'){
                    //如果没有网络连接，直接提示无网络
                    if(ifeng.checkNetWorkState() == 0) {
                        return;
                    }
                    if(loadMode == 1 || offlineMode) {
                        this.style.backgroundImage = 'url('+nophoto_arrays[1]+')';
                    } else {
                        this.innerHTML = loadMessage;
                    }
                    this.setAttribute('loadState','loading');
                    Ground.loadImageDirectly(src, docId,
                        loadImageSuccessInterceptor(this),
                        loadImageFailInterceptor(this, src),'forceLoad');
                }
            }
        };
    }

//	if (imgQuene.length > 0 && imgQuene[0].ot > VIEWPORT_HEIGHT * 4) {
    // 如果第一张图的底部是屏幕高度的4倍还多，认为获得图片高度不正确，比如手机Huawei Y220-T10
    // 打开长文章时会出现这种情况，为避免图片不能按高度加载，出现这种情况时一次性加载出正文的所有图片
    // fix bug #17146
//		VIEWPORT_HEIGHT = imgQuene[0].ot;
//	}

    // 滚动时的判断 执行加载
//    var scrollToLoad = function() {
//        var bt = document.body.scrollTop + VIEWPORT_HEIGHT * 3 + delatHeight; // 加载3屏
// console.log('scrollToLoad: VIEWPORT_HEIGHT=' + VIEWPORT_HEIGHT + ', scrollTop=' + document.body.scrollTop + ', !!!!bt=' + bt);
//        for(var j = 0, len = imgQuene.length; j < len; j++){
//            var d = imgQuene[j];
//            if(!d) continue;
//            if(bt > d.ot && (bt - d.ot) < (VIEWPORT_HEIGHT * 4)){
//            		 Ground.loadImage(d.src, docId,
//                             loadImageSuccessInterceptor(d.dom, j),
//                             loadImageFailInterceptor(d.dom, d.src), 'false');
//            		 imgQuene[j] = false;
//            }
//        }
//    }

//	if (imgQuene.length > 0 && imgQuene[0].ot > VIEWPORT_HEIGHT * 4) {
//		// 如果第一张图的底部是屏幕高度的4倍还多，认为获得图片高度不正确，比如手机Huawei Y220-T10
//		// 打开长文章时会出现这种情况，为避免图片不能按高度加载，出现这种情况时一次性加载出正文的所有图片
//		// fix bug #17146

    for(var j = 0, len = imgQuene.length,load; j < len; j++){
        var d = imgQuene[j];
        if(d.dom.getAttribute('imgsrc')) {
            handle_video_message(d.dom, 1);
            if(offlineMode) {
                load = false;
            } else {
                load = true;
            }
        } else if(d.dom.getAttribute('slidesrc') && offlineMode){
            load = false;
        } else {
            load = true;
        }
        Ground.loadImage(d.src, docId,
            loadImageSuccessInterceptor(d.dom, j),
            loadImageFailInterceptor(d.dom, d.src), 'false', load);

    }
    ifeng.startDownload();

    // 滚动结束时 执行 scrollToLoad
//		window.addEventListener('scroll', function() {
//			throttle(scrollToLoad);
//		}, false);
//
//		scrollToLoad();
}

/*
 处理视频图片加载状态
 state
 0 未加载
 1 正在加载
 2 加载失败
 3 加载成功显示btn
 4 加载成功不显示btn
 */
function handle_video_message(item, state) {
    try {
        var loadMessage = '';
        switch(state) {
            case 0:
            case 2:
                loadMessage = '<span class="load-message">点击加载视频</span>';
                if(loadMode != 1 || offlineMode) {
                    item.innerHTML = loadMessage+'<div class="video_bottom_content_hide"><div class="video_right_button"><img src="video_button.png"/></div></div>';
                } else {
                    item.innerHTML = loadMessage;
                }
                break;
            case 1:
                loadMessage = '<span class="load-message">正在载入...</span>';
                item.innerHTML = loadMessage+'<div class="video_bottom_content_hide"><div class="video_right_button"><img src="video_button.png"/></div></div>';
                break;
            case 3:
                item.innerHTML = '<div class="video_top"></div><div class="video_bottom"></div><div class="video_bottom_content_show"><div class="video_right_button"><img src="video_button.png"/></div></div>';
                break;
            case 4:
                item.innerHTML = '';
                break;
        }
    }catch(e){console.log("error:"+e);};
}


function setImageHeight(placeholder) {
    var height = placeholder.getAttribute("image_height");
    if(height && Object.prototype.toString.call(height) == '[object String]') {
        placeholder.style.height = placeholder.style.minHeight = placeholder.style.maxHeight= height;
        ifeng.resize(document.body.getBoundingClientRect().height);
    }
}


// 图片加载的成功回调
function loadImageSuccessInterceptor(placeholder, imgPosition) {
    return function(src) {
        if(placeholder.nodeName != 'IMG'){
            if(placeholder.getAttribute('imgsrc')) {
                if(src == "none" && loadMode == 1) {
                    handle_video_message(placeholder,4);
                } else {
                    handle_video_message(placeholder,3);
                }
            } else {
                placeholder.innerHTML = '';
            }
        }
        if(src == "none") {
            //设置了无图模式并且网络为2G/3G
            if(offlineMode) {
                placeholder.style.backgroundSize="177.5px 15.5px";
                placeholder.style.backgroundImage = 'url('+nophoto_arrays[0]+')';
            }
            else if(loadMode == 1) {
                if(placeholder.getAttribute('imgsrc')){
                    placeholder.style.backgroundImage = 'url(video_no_load.png),url()';
                }
                else if(placeholder.getAttribute('slidesrc')){
                    placeholder.style.backgroundImage = 'url(slide_text.png),url(logo_no_load.png)';
                } else if(placeholder.getAttribute('advertsrc')){
                    document.getElementById('advertdiv').style.display = 'none';
                }else if(placeholder.getAttribute('likeSrc') || placeholder.getAttribute('recommendSrc')||placeholder.getAttribute('readImgSrc')) {
                    placeholder.src = 'list_no_img.JPG';
                }
                else {
                    placeholder.style.backgroundSize="177.5px 15.5px";
                    placeholder.style.backgroundImage = 'url('+nophoto_arrays[0]+')';
                }
            }
            placeholder.setAttribute('loadState','loadFail');
            return;
        }

        //加载成功了
        var className = placeholder.className;
//		imgQuene[imgPosition] = false;
        if (className.indexOf('loaded') > -1) {
            return;
        }
        if(placeholder.getAttribute('commentImageSrc') || placeholder.getAttribute('likeSrc') || placeholder.getAttribute('recommendSrc')||placeholder.getAttribute('readImgSrc')) {
            placeholder.src = src;
        }
        else if(placeholder.getAttribute('imgsrc')) {
            setImageHeight(placeholder);
            placeholder.style.backgroundSize = '100%,100%';
            placeholder.style.backgroundImage = 'url('+src+')';
        }
        else if(placeholder.getAttribute('advertsrc')) {
            document.getElementById('advertdiv').style.width = ifeng.getScreenWidth()-60 +'px';
            document.getElementById('advertdiv').style.height = Math.round((ifeng.getScreenWidth()-120) / BODY_AD_CENTER_RADIO)+'px';
            placeholder.src = src;

            var adCloseEl = document.getElementById('ad-close');
            adCloseEl.onclick = function (event){
                        ifeng.setCenterAdHint();
                        document.getElementById('advertdiv').style.display = 'none';
                        event.stopPropagation();
                    };
            if(datas.getDocAdClose() == '1'){
                       adCloseEl.style.display = 'visibility';
                    }else{
                        adCloseEl.style.display = 'none';
                    }
            ifeng.setCenterAdPosition(offsetTop(document.getElementById('advertdiv')));
            ifeng.setCenterAdHeight(Math.round((ifeng.getScreenWidth()-120)/BODY_AD_CENTER_RADIO));
        }
        else if(placeholder.getAttribute('slidesrc')) {
            setImageHeight(placeholder);
            placeholder.style.backgroundImage = 'url(slide_text.png),url('+src+')';
            placeholder.style.backgroundSize = '40px 22px,cover';
        }
        else {
            setImageHeight(placeholder);
            placeholder.style.backgroundSize = '100%,100%';
            placeholder.style.backgroundImage = 'url(' + src + ')';
            placeholder.style.backgroundPosition = 'center top';
            placeholder.style.backgroundColor = 'transparent';
        }
        placeholder.className = className + ' loaded';

    };
}


function loadImageFailInterceptor(placeholder, src) {
    return function() {
        if(offlineMode) {
            if(placeholder.nodeName != 'IMG'){
                if(placeholder.getAttribute('imgsrc')) {
                    handle_video_message(placeholder, 2);
                } else if(placeholder.getAttribute('slidesrc')){
                    placeholder.innerHTML = '<span class="load-message">点击加载图片</span>';
                } else if(placeholder.getAttribute('advertsrc')){
                   document.getElementById('advertdiv').style.display = 'none';
                }else {
                    placeholder.style.backgroundSize="177.5px 15.5px";
                    placeholder.style.backgroundImage = 'url('+nophoto_arrays[2]+')';
                }
            }
        }
        else if (loadMode == 1) {
            if(placeholder.getAttribute('imgsrc')) {
                placeholder.style.backgroundImage = 'url(video_load_fail.png),url()';
            }
            else if(placeholder.getAttribute('advertsrc')) {
               document.getElementById('advertdiv').style.display = 'none';
            }
            else if(placeholder.getAttribute('slidesrc')) {
                placeholder.style.backgroundImage = 'url(slide_text.png),url(logo_load_fail.png)'
            }
            else if(placeholder.getAttribute('recommendSrc')||placeholder.getAttribute('readImgSrc')) {
                placeholder.src = 'list_no_img.JPG';
            }
            else if(placeholder.getAttribute('likeSrc')) {
                placeholder.src = 'album_no_img.JPG';
            }
            else {
                placeholder.style.backgroundSize="177.5px 15.5px";
                placeholder.style.backgroundImage = 'url('+nophoto_arrays[2]+')';
            }
        } else {
            if(placeholder.nodeName != 'IMG'){
                if(placeholder.getAttribute('imgsrc')) {
                    handle_video_message(placeholder, 2);
                } else {
                    placeholder.innerHTML = '<span class="load-message">点击加载图片</span>';
                }
            }
            if(placeholder.getAttribute('recommendSrc')||placeholder.getAttribute('readImgSrc')) {
                placeholder.src = 'list_default.jpg';
            }
            else if(placeholder.getAttribute('likeSrc')) {
                placeholder.src = 'album_default.JPG';
            }
        }
        placeholder.setAttribute('loadState', 'loadFail');
        sendWebLog('loadImageFailInterceptor load img fail', src);
    };
}

// 订阅模块加载失败回调
function loadSubscriptImageFailInterceptor(placeholder, src) {
    return function() {

        if (loadMode == 1) {
            if(placeholder.getAttribute('imgsrc')) {
                placeholder.style.backgroundImage = 'url(video_load_fail.png),url()';
            }
            else if(placeholder.getAttribute('slidesrc')) {
                placeholder.style.backgroundImage = 'url(slide_text.png),url(logo_load_fail.png)'
            }
            else {
                placeholder.style.backgroundImage = 'url(logo_load_fail.png)';
            }
        } else {
            //	placeholder.innerHTML = '<span class="load-message">点击加载图片</span>';
        }
        placeholder.style.backgroundPosition = 'center top';
        placeholder.setAttribute('loadState', 'loadFail');
        sendWebLog('loadSubscriptImageFailInterceptor load img fail', src);
    };
}


function loadSurvey(){
    Ground.loadSurvey(buildSurvey, null);
}

function buildSurvey(survey, isSurved){
    if(!survey||Object.prototype.toString.call(survey) !== '[object String]'){
        return false;
    }
    var surveyData;
    try {
        survey = decodeURIComponent(survey);
    }catch(e){}
    try{
        surveyData = JSON.parse(survey);
    } catch (e) {
        surveyData = undefined;
    }
    if(surveyData.result.length<1){
        return false;
    }
    document.getElementById("split").style.display = "block";
    var vote_content = document.getElementById("vote");
    var vote_title = document.getElementById("vote-title");
    var vote_share = document.getElementById("vote-share");
    var vote_discription = document.getElementById("vote-discription");
    var vote_list = document.createElement("ul");
    var vote_item = document.createElement("li");
    var percent_img = document.createElement("div");
    var percent_lable = document.createElement("span");
    var count_lable = document.createElement("span");
    var percent_title = document.createElement("div");
    var goto_survey = document.createElement("div");
    vote_share.style.display = "none";
    vote_content.style.display = "block";
    if(isSurved||surveyData.surveyinfo.isactive=="1"){
        vote_discription.innerHTML = "进行中  "+surveyData.surveyinfo.pnum+"人参与";
    }else{
        vote_discription.innerHTML = "已结束  "+surveyData.surveyinfo.pnum+"人参与";
    }
    if(surveyData.surveyinfo.isactive=="1"){
        goto_survey.innerHTML = "<div>参与调查</div>";
    }else{
        goto_survey.innerHTML = "<div>查看结果</div>";
    }
    vote_list.className = "vote-list";
    vote_item.className = "vote-item";
    vote_item.style.paddingLeft = "14px"
    percent_img.className = "percent-img";
    percent_lable.className = "percent-lable";
    count_lable.className = "count-lable";
    percent_title.className = "vote-item-title";
    var highest_result= 0;
    var highest_item = 0;
    //区百分比最高项进行显示
    for(var j=0;j<surveyData.result.length;j++){
        for(var i=0;i<surveyData.result[j].resultArray.option.length;i++){
            if(surveyData.result[j].resultArray.option[i].nump*10>
                surveyData.result[highest_result].resultArray.option[highest_item].nump*10){
                highest_item = i;
                highest_result = j;
            }
        }
    }

    vote_item.style.backgroundImage = 'url(single_split.png),url(vote_1.png)';
    percent_img.style.background = "#11c0f5";
    vote_title.innerHTML = surveyData.result[highest_result].resultArray.question+" (共"+surveyData.result.length+"题)";
    goto_survey.setAttribute("id", "to-survey");
    goto_survey.className = "to-survey";
    goto_survey.onclick = function(){
        ifeng.goToSurvey(surveyData.surveyinfo.id);
    }

    percent_img.onload = statisticBarLoaded(percent_img, surveyData.result[highest_result].resultArray.option[highest_item].nump);
    percent_lable.innerHTML = surveyData.result[highest_result].resultArray.option[highest_item].nump+ '<span class="percent">%</span>';

    count_lable.innerHTML = surveyData.result[highest_result].resultArray.option[highest_item].num+"票";

    percent_title.innerHTML = surveyData.result[highest_result].resultArray.option[highest_item].title;
    vote_item.appendChild(percent_img);
    vote_item.appendChild(percent_lable);
    vote_item.appendChild(count_lable);
    vote_item.appendChild(percent_title);
    vote_list.appendChild(vote_item);
    vote_content.appendChild(vote_list);
    vote_content.appendChild(goto_survey);
}
function buildSingleSurvey(survey, isSurved){
    var survey_content = document.createElement("div");
    var survey_title = document.createElement("div");
    var survey_discription = document.createElement("span");
    var survey_list = document.createElement("ul");
    var survey_item = document.createElement("li");
    var percent_img = document.createElement("div");
     var percent_img_bg = document.createElement("div");
    var percent_lable = document.createElement("span");
    var count_lable = document.createElement("span");
    var percent_title = document.createElement("div");
    var goto_survey = document.createElement("div");
    survey_content.style.display = "block";
    if(isSurved||(survey.surveyinfo.isactive=="1"&&survey.surveyinfo.expire=="1")){
        if(isSurved){
            survey.surveyinfo.isactive="0"
        }
        survey_discription.innerHTML = '进行中&nbsp&nbsp<span class="survey-discription-count">'+survey.surveyinfo.pnum+'</span>人参与&nbsp&nbsp共'+survey.surveyinfo.questionids.length+'题';
    }else{
        survey_discription.innerHTML = '已结束&nbsp&nbsp<span class="survey-discription-count">'+survey.surveyinfo.pnum+'</span>人参与&nbsp&nbsp共'+survey.surveyinfo.questionids.length+'题';
    }
    if(survey.surveyinfo.isactive=="1"&&survey.surveyinfo.expire=="1"){
        goto_survey.innerHTML = "<div>参与调查</div>";
    }else{
        goto_survey.innerHTML = "<div>查看结果</div>";
    }
    survey_content.className = "vote";
    survey_title.className = "survey-title";
    survey_discription.className = "survey-discription";
    survey_list.className = "vote-list";
    survey_item.className = "survey-item";
    survey_item.style.paddingLeft = "14px"
    percent_img.className = "percent-img";
    percent_img_bg.className = "percent-img-bg";
    percent_lable.className = "percent-lable";
    count_lable.className = "count-lable";
    percent_title.className = "vote-item-title";
    var highest_result= 0;
    var highest_item = 0;
    //区百分比最高项进行显示
    for(var j=0;j<survey.result.length;j++){
        for(var i=0;i<survey.result[j].resultArray.option.length;i++){
            if(survey.result[j].resultArray.option[i].nump*10>
                survey.result[highest_result].resultArray.option[highest_item].nump*10){
                highest_item = i;
                highest_result = j;
            }
        }
    }
    survey_item.style.backgroundImage = 'url(single_split.png),url(vote_1.png)';
    survey_item.style.paddingRight = "0px";
    percent_img.style.background = "#11c0f5";
    percent_img_bg.style.background = "#F0F0F0";
    percent_img_bg.style.width = "58%";
    survey_title.innerHTML = survey.surveyinfo.title;
    goto_survey.setAttribute("id", "to-survey");
    goto_survey.className = "to-survey";
    goto_survey.setAttribute("onclick", "goToSurvey("+survey.surveyinfo.id+")");
//    goto_survey.onclick = function(){
//        ifeng.goToSurvey(survey.surveyinfo.id);
//    }
    // percent_img.onload = statisticBarLoaded(percent_img, survey.result[highest_result].resultArray.option[highest_item].nump);
    percent_img.style.width =survey.result[highest_result].resultArray.option[highest_item].nump + '%';
    percent_img_bg.style.verticalAlign="5px";
    percent_lable.innerHTML = survey.result[highest_result].resultArray.option[highest_item].nump+ '<span class="percent">%</span>';
    count_lable.innerHTML = survey.result[highest_result].resultArray.option[highest_item].num+"票";
    percent_title.innerHTML = survey.result[highest_result].resultArray.option[highest_item].title;
    percent_img_bg.appendChild(percent_img);
    survey_item.appendChild(percent_img_bg);
    survey_item.appendChild(percent_lable);
    survey_item.appendChild(count_lable);
    survey_item.appendChild(percent_title);
    survey_list.appendChild(survey_item);
    survey_content.appendChild(survey_title);
    survey_content.appendChild(survey_discription)
    survey_content.appendChild(survey_list);
    survey_content.appendChild(goto_survey);

    return survey_content.innerHTML;
}
function goToSurvey(survey_id){
    ifeng.goToSurvey(survey_id);
}

function buildMulSurvey(content){
    // 显示调查
    var surveyListStr = datas.getSurveylistJson();
    if(surveyListStr&&Object.prototype.toString.call(surveyListStr) == '[object String]'){

        var surveyList = JSON.parse(surveyListStr);
        content = handle_survey_position(content,survey_p,surveyList.length,
            function(i) {
                var survey_position = i;
                var surveys_item = surveyList[survey_position];
                var surveyItemContent = "";
                var resultList = surveys_item.result;
                var onequestion = surveys_item.onequestion;
                var isactive = surveys_item.surveyinfo.isactive;//是否下线
                var expire = surveys_item.surveyinfo.expire;//是否过期
                var isSurveyed = ifeng.getSurveyed(surveys_item.surveyinfo.id);
               // alert(isactive+" "+expire+" "+isSurveyed);
                if(onequestion==1){
                  var survey_head = '<div class="split-2" id="survey_head" style="width:92%;display:inline-block;">民调 </div><div class="survey" style="display:block" id="survey-content">';
                  surveyItemContent+=survey_head;
                  var single_survey_content =  buildSingleSurvey(surveys_item,isSurveyed);
                  surveyItemContent +=single_survey_content;
                  surveyItemContent +='</div>'

                }else{
                  var msg="";
                   if(isactive=="1"&&expire=="1"){
                     msg = "进行中";
                   }else{
                     msg = "已结束";
                   }
                   var survey_head = '<div class="split-2" ><div id="survey_head" style="display:inline-block;">民调 </div><div style="inline-block;float:right"><span class="survey-discription" id="survey-discription">'+msg+'&nbsp&nbsp<span class="survey-discription-count">'+surveys_item.surveyinfo.votecount+'</span>人参与</span></div></div><div class="survey" style="display:block" id="survey-content-'+survey_position+'"><div style="display:block" id="survey-content-tag-'+survey_position+'"><div class="survey-item-title" id="survey-title">'+surveys_item.surveyinfo.title+'</div>';
                  surveyItemContent+=survey_head;
                    var resultNum = resultList.length;
                    for (var j = 0; j < resultNum; j++) {
                        var resultItem = resultList[j].resultArray;
                        var question_num = j+1;
                        if(isactive=="1"&&!isSurveyed&&expire=="1"){
                            if(resultItem.choosetype =="single") {
                                var num=resultItem.option.length;
                                var str_ul = '<div><div class="survey-title">'+question_num+'. '+resultItem.question+'</div>'
                                surveyItemContent += str_ul;
                                for (var i = 0; i < num; i++) {
                                    var id = resultItem.option[i].itemid;
                                    var str_survey_item = '<div class="check-box"   onclick="surveySingleItemClick('+survey_position+','+j+','+id+');"><input type="radio"  id="'+resultItem.option[i].itemid+'" name="'+resultItem.questionid+'" /><label for="'+resultItem.option[i].itemid+'"><span style="padding-left:40px;line-height:1.7;margin-top: 18px">'+resultItem.option[i].title+'</span></label></div>'
                                    surveyItemContent +=str_survey_item;
                                }
                                surveyItemContent +='</div>';
                            }else{
                                var num=resultItem.option.length;
                                var str_survey = '<div><div class="survey-title">'+question_num+'. '+resultItem.question+'</div>'
                                surveyItemContent += str_survey;
                                for (var i = 0; i < num; i++) {
                                    var id = resultItem.option[i].itemid;
                                    var str_survey_item = '<div class="check-box"   onclick="surveyMultiItemClick('+survey_position+','+j+','+id+');"><input type="checkbox"  id="'+id+'" name="'+resultItem.questionid+'" /><label for="'+resultItem.option[i].itemid+'"><span style="padding-left: 28px">'+resultItem.option[i].title+'</span></label></div>'
                                    surveyItemContent +=str_survey_item;
                                }
                                surveyItemContent +='</div>';
                            }

                        }else{
                            var str_ul = '<div><div class="survey-title">'+question_num+'. '+resultItem.question+'</div>'
                            surveyItemContent+=str_ul;
                            var survey_list = document.createElement("ul");
                            survey_list.className = "vote-list";
                            survey_list.setAttribute("id", "survey-list");
                            buildSurveyResults(resultItem.option, survey_list);
                            surveyItemContent+=survey_list.innerHTML+'</div>';
                        }



                    }
                    if(isactive=="1"&&expire=="1"&&!isSurveyed){
                        surveyItemContent +='<div class="submit-survey" style="display:block" onclick="submitSurvey('+surveys_item.surveyinfo.id+','+survey_position+');"><span>提交</span></div></div></div>'
                    }else{
                        surveyItemContent +='</div></div>'
                    }
                }
                return surveyItemContent;
            });

    }
    return content;

}
function surveySingleItemClick(i,resultPosition,itemid){

    ifeng.surveySingleChoice(i,resultPosition,itemid);

}
function surveyMultiItemClick(i,resultPosition,itemid){

    var ischecked =document.getElementById(itemid).checked;
    ifeng.surveyMultiChoice(i,resultPosition,ischecked,itemid);

}
function submitSurvey(id,survey_position){
    Ground.submitSurvey(id,survey_position,buildSurveySubmmitedResults,null);
}

function buildSurveySubmmitedResults(survey,i){
    if(survey&&Object.prototype.toString.call(survey) == '[object String]'){
        var surveyList = JSON.parse(survey);
        var survey_content = document.getElementById("survey-content-"+i);
        var survey_content_tag = document.getElementById("survey-content-tag-"+i);
        var survey_result = document.createElement("div");
        var result_list = surveyList[i].result;
        for(var i = 0;i<result_list.length;i++){

            var result_item = result_list[i].resultArray;
            var result_item_option = result_item.option;
            var survey_result_title =  document.createElement("div");
            var survey_list = document.createElement("ul");
            survey_result_title.className = "survey-title";
            var question_num = i+1;
            survey_result_title.innerHTML = question_num+'. '+result_item.question;
            survey_list.className = "vote-list";
            survey_list.setAttribute("id", "survey-list");
            buildSurveyResults(result_item_option, survey_list);
            survey_result.appendChild(survey_result_title);
            survey_result.appendChild(survey_list);

        }
        survey_content.replaceChild(survey_result,survey_content_tag);
    }
}
function buildVote(vote, isVoted){
    if(!vote||Object.prototype.toString.call(vote) !== '[object String]'){
        return false;
    }
    try{
        vote = decodeURIComponent(vote);
    }catch(e){}

    VOTEDATA = JSON.parse(vote)
    if(!VOTEDATA.votecount){
        VOTEDATA.votecount = 0;
    }
    document.getElementById("split").style.display = "block";
    var vote_content = document.getElementById("vote");
    var vote_title = document.getElementById("vote-title");
    var vote_share = document.getElementById("vote-share");
    var vote_end = document.createElement("span");
    vote_title.innerHTML = VOTEDATA.topic;
    var vote_discription = document.getElementById("vote-discription");
    var vote_list = document.createElement("ul");
    vote_list.className = "vote-list";
    vote_list.setAttribute("id", "vote-list");
    vote_end.className = "vote-end";
    vote_end.setAttribute("id","vote-end");
    vote_content.style.display = "block";
    if(VOTEDATA.isactive){
        vote_discription.innerHTML = "进行中  "+VOTEDATA.votecount+"人参与";
        buildVoteFace(VOTEDATA.iteminfo, vote_list);
        vote_end.innerHTML = "点击选项投票 投票后查看结果";
    }else{
        if(isVoted){
            vote_discription.innerHTML = "进行中  "+VOTEDATA.votecount+"人参与";
        }else{
            vote_discription.innerHTML = "投票已过期   "+VOTEDATA.votecount+"人参与";
        }
        buildVoteResults(VOTEDATA.iteminfo, vote_list);
        vote_end.innerHTML = "感谢您的参与";
    }
    vote_share.onclick = function(){
        ifeng.shareVoteData(VOTEDATA.topic);
    }
    vote_content.appendChild(vote_list);
    vote_content.appendChild(vote_end);

}

function buildVoteFace(iteminfo, vote_list){
    var num=iteminfo.length;
    for (var i = 0; i < num; i++) {
        var vote_item = document.createElement("li");
        var percent_lable = document.createElement("span");
        vote_item.className = "vote-item";
        vote_item.style.paddingLeft = "28px"
        percent_lable.className = "percent-lable";
        percent_lable.innerHTML = iteminfo[i].title;
        vote_item.setAttribute("id", iteminfo[i].id);
        vote_item.appendChild(percent_lable);
        vote_item.onclick = function(){
            Ground.submitVote(VOTEDATA.id,this.getAttribute("id"),buildSubmmitedResults,null);
        };
        vote_list.appendChild(vote_item);
    }
}

function buildSubmmitedResults(vote){
    var colors = ["#ff2c49","#11c0f5","#ffd500","#0088ba","#80e131"];
    var vote_items = document.getElementById("vote-list").getElementsByTagName("li");
    var num=vote_items.length;
    var lastPercent = 0;
    var vote_discription = document.getElementById("vote-discription");
    VOTEDATA = JSON.parse(vote);
    var reg = new RegExp("\\d+","gmi");
    vote_discription.innerHTML = vote_discription.innerHTML.replace(reg, VOTEDATA.votecount);
    for (var i = 0; i < num; i++) {
        vote_items[i].onclick = "";
        var currentPercent;
        var percent_img_bg = document.createElement("div");
        var percent_img = document.createElement("div");
        var percent_lable = document.createElement("span");
        var count_lable = document.createElement("span");
        var percent_title = document.createElement("div");
        vote_items[i].style.backgroundImage = 'url(single_split.png),url(vote_'+i % colors.length+'.png)'
        vote_items[i].style.paddingLeft = "14px"
        percent_img.className = "percent-img";
        percent_img_bg.className = "percent-img-bg";
        percent_lable.className = "percent-lable";
        count_lable.className = "count-lable";
        percent_title.className = "vote-item-title";
        percent_img_bg.style.background = "#F0F0F0";
        percent_img_bg.style.width ="58%"
         percent_img_bg.style.verticalAlign="2px";
        percent_img.style.background = colors[i % colors.length];
        percent_img.onload = statisticBarLoaded(percent_img,VOTEDATA.iteminfo[i].nump);
        percent_lable.innerHTML = VOTEDATA.iteminfo[i].nump+ '<span class="percent">%</span>';
        count_lable.innerHTML = VOTEDATA.iteminfo[i].votecount+"票";
        percent_title.innerHTML = VOTEDATA.iteminfo[i].title;
        vote_items[i].removeChild(vote_items[i].getElementsByTagName("span")[0]);
        percent_img_bg.appendChild(percent_img);
        vote_items[i].appendChild(percent_img_bg);
        vote_items[i].appendChild(percent_lable);
        vote_items[i].appendChild(count_lable);
        vote_items[i].appendChild(percent_title);
    }
    document.getElementById("vote-end").innerHTML = "感谢您的参与";
}

function formatFloat(number) {
    return Math.round(number*1000);
}

function buildVoteResults(iteminfo, vote_list){
    var colors = ["#ff2c49","#11c0f5","#ffd500","#0088ba","#80e131"];
    var num=iteminfo.length;
    for (var i = 0; i < num; i++) {
        var vote_item = document.createElement("li");
        var percent_img = document.createElement("div");
        var percent_img_bg = document.createElement("div");
        var percent_lable = document.createElement("span");
        var count_lable = document.createElement("span");
        var percent_title = document.createElement("div");
        vote_item.className = "survey-item";
        vote_item.style.backgroundImage = 'url(single_split.png),url(vote_'+i % colors.length+'.png)'
        percent_img.className = "percent-img";
         percent_img_bg.className = "percent-img-bg";
        percent_lable.className = "percent-lable";
        count_lable.className = "count-lable";
        percent_title.className = "vote-item-title";
        percent_img_bg.style.background = "#F0F0F0";
        percent_img_bg.style.width ="58%"
        percent_img.style.background = colors[i % colors.length];
        percent_img_bg.style.verticalAlign="2px";
        percent_img.onload = statisticBarLoaded(percent_img,iteminfo[i].nump);
        percent_lable.innerHTML = iteminfo[i].nump + '<span class="percent">%</span>';
        count_lable.innerHTML = iteminfo[i].votecount+"票";
        percent_title.innerHTML = iteminfo[i].title;
        percent_img_bg.appendChild(percent_img);
        vote_item.appendChild(percent_img_bg);
        vote_item.appendChild(percent_lable);
        vote_item.appendChild(count_lable);
        vote_item.appendChild(percent_title);
        vote_list.appendChild(vote_item);
    }
}
function buildSurveyResults(iteminfo, vote_list){
    var colors = ["#ff2c49","#11c0f5","#ffd500","#0088ba","#80e131"];
    var num=iteminfo.length;
    for (var i = 0; i < num; i++) {
        var vote_item = document.createElement("li");
        var percent_img = document.createElement("div");
        var percent_img_bg = document.createElement("div");
        var percent_lable = document.createElement("span");
        var count_lable = document.createElement("span");
        var percent_title = document.createElement("div");
        vote_item.className = "survey-item";
        vote_item.style.listStyle="none";
        vote_item.style.backgroundImage = 'url(single_split.png),url(vote_'+i % colors.length+'.png)';
        percent_img.className = "percent-img";
        percent_img_bg.className = "percent-img-bg";
        percent_lable.className = "percent-lable";
        count_lable.className = "count-lable";
        percent_title.className = "vote-item-title";
        percent_img_bg.style.background = "#F0F0F0";
        percent_img_bg.style.width ="58%"
        percent_img.style.background = colors[i % colors.length];
        percent_img.style.width = iteminfo[i].nump + '%';
        percent_img_bg.style.verticalAlign="5px";
        percent_img.setAttribute("id","percent-img-survey");
        percent_img.onload = statisticBarLoaded(percent_img,iteminfo[i].nump);
        percent_lable.innerHTML = iteminfo[i].nump + '<span class="percent">%</span>';
        count_lable.innerHTML = iteminfo[i].num+"票";
        percent_title.innerHTML = iteminfo[i].title;
        percent_img_bg.appendChild(percent_img);
        vote_item.appendChild(percent_img_bg);
        vote_item.appendChild(percent_lable);
        vote_item.appendChild(count_lable);
        vote_item.appendChild(percent_title);
        vote_list.appendChild(vote_item);
    }

}

function statisticBarLoaded(element,percentage){
    var pos, runTime,
        startTime = + new Date,
        timer = setInterval(function () {
            runTime = + new Date - startTime;
            pos = runTime /1000;
            if (pos >= 1) {
                clearInterval(timer);
                element.style.width = percentage + '%';
            } else {
                element.style.width = percentage*pos + '%';
            };
        }, 100);
}


// 发送日志
function sendWebLog(type, msg, e) {
    var docId = datas.getDocumentId() || 'null doc id',
        eMsg = e && e.message ? e.message : 'null error msg';

    ifeng.webLog(docId + '---' + type + '---' + eMsg + '---' + msg);
}

// 函数节流包装器
function throttle(method, context) {
    clearTimeout(method.tId);
    method.tId = setTimeout(function(){
        method.call(context);
    }, 100);
}

// 与native交互实现
(function() {
    var toString = function(v) {
        return Object.prototype.toString.call(v);
    }, isFunction = function(v) {
        return toString(v) === '[object Function]';
    }, athene = {}, CALLBACK_PREFIX = 'callback__', callbacks = {}, callbackCount = 0, CallbackStatus = {
        OK : 1
    };
    athene.exec = function(success, fail, service, action, params) {
        var callbackId = CALLBACK_PREFIX + callbackCount++;
        callbacks[callbackId] = {
            success : success,
            fail : fail
        };
        params = Array.prototype.concat.call([], callbackId, params || []);
        action.apply(service, params);
    };
    athene.complete = function() {
        if (arguments.length < 2) {
            throw new Error('Missing essential arguments');
        }
        var callbackId = arguments[0], status = arguments[1], callback = callbacks[callbackId], params = Array.prototype.slice
            .call(arguments, 2), success, fail;
        delete callbacks[callbackId];
        if (!callback) {
            return;
        }
        success = callback.success;
        fail = callback.fail;
        if (status == CallbackStatus.OK && isFunction(success)) {
            success.apply(null, params);
//            console.log('params= '+ params[0]);
        } else if (isFunction(fail)) {
            fail.apply(null, params);
        }
    }
    athene.updata = function(){
        var vote_content = document.getElementById("to-survey");
        if(arguments[0]==0){
            vote_content.innerHTML = "<div>查看结果</div>";
        }
    }
    window['athene'] = athene;
})();

// ground 接口
(function() {
    var Ground = {
        loadImage : function(src, documentId, success, fail, forceLoad, load) {
            athene.exec(success, fail, ifeng, ifeng.loadImage, [ src,
                documentId, forceLoad, load]);
        },
        loadImageDirectly : function(src, documentId, success, fail, forceLoad) {
            athene.exec(success, fail, ifeng, ifeng.loadImageDirectly, [ src, documentId,
                forceLoad]);
        },
        popupLightbox : function(src, success) {
            athene.exec(success, null, ifeng, ifeng.popupLightbox, [ src ]);
        },
        loadAdv01 : function(documentId, success, fail) {
            athene.exec(success, fail, ifeng, ifeng.loadAdv01, [documentId]);
        },
        loadAdv02 : function(documentId, success, fail) {
            athene.exec(success, fail, ifeng, ifeng.loadAdv02, [documentId]);
        },
        loadAdv2 : function(documentId, success, fail) {
            athene.exec(success, fail, ifeng, ifeng.loadAdv2, [documentId]);
        },
        getHotComments: function(commentsUrl, documentId, success, fail) {
            athene.exec(success, fail, ifeng, ifeng.getHotComments, [commentsUrl, documentId]);
        },
        loadVote : function(success, fail) {
            athene.exec(success, fail, ifeng, ifeng.getVoteData);
        },
        submitVote : function(id, itemid, success, fail) {
            athene.exec(success, fail, ifeng, ifeng.submitVoteData, [id, itemid]);
        },
        submitSurvey : function(id,survey_position,success, fail) {
            athene.exec(success, fail, ifeng, ifeng.submitSurveyData, [id,survey_position]);
        },
        loadSurvey : function(success, fail) {
            athene.exec(success, fail, ifeng, ifeng.getSurveyData);
        },
        addSubscribe : function(success, fail) {
            athene.exec(success, fail, ifeng, ifeng.addSubscribe);
        },
        isSubscribe  : function(success, fail) {
            athene.exec(success, fail, ifeng, ifeng.isSubscribe);
        },
        close  : function() {
            athene.exec("", "", ifeng, ifeng.windowClose);
        },
    };

    window['Ground'] = Ground;
})();


// 屏幕宽度检测
(function() {
    var retry = 0;
    var ScreenDetector = {
        MAX_RETRY_TIMES : 30,
        INTERVAL : 5,
        STORAGE_WIDTH_KEY : '__devicewidth__', // localStorage 存储宽度值的 key

        launch : function() {

            var storage = window.localStorage, isReady = storage
                && storage.getItem(this.STORAGE_WIDTH_KEY); // 已存储过代表已准备好

            if (isReady) {
                this._ready();

            } else {
                this._docWidth = document.body.clientWidth;
                this._retryTimes = 0;
                this._start();
            }
        },
        _start : function() {
            var self = this;
            setTimeout(function() {
                self._detect();
            }, this.INTERVAL);
        },
        _detect : function() {

            var currentDocWidth,self = this;
            if(datas.getArticleWidth()){
                currentDocWidth = document.body.clientWidth;
            }else{
                currentDocWidth = document.body.clientWidth;
            }
            if (this._retryTimes < this.MAX_RETRY_TIMES) {
                this._retryTimes++;
                if (this._docWidth != currentDocWidth) {
                    self._ready(currentDocWidth);
                } else {
                    setTimeout(function() {
                        self._detect();
                    }, this.INTERVAL);
                }

            } else {
                self._ready(self._docWidth);
            }
        },
        /**
         * 屏幕宽度检测完成 派发deviceready事件
         *
         * @param docWidth
         *            设置 localstorage 中的 width 值
         * @private
         */
        _ready : function(docWidth) {
            var storage = window.localStorage, clientWidth, ev;
//            for(var i=0;i<7;i++) {
//            	VIEWPORT_HEIGHT = window.innerHeight;
//            	if(VIEWPORT_HEIGHT) {
//            		break;
//            	}
//            }
            if (docWidth && storage) {
                storage.setItem(this.STORAGE_WIDTH_KEY, docWidth);
            }
            // 设置 e.clientWidth 变量的值 方便业务逻辑中使用
            clientWidth = parseInt(docWidth
                || storage.getItem(this.STORAGE_WIDTH_KEY));
            ev = document.createEvent('Event');
            ev.clientWidth = clientWidth;
            ev.initEvent('deviceready', false, true);
            window.dispatchEvent(ev);
        }
    };
    window.addEventListener('load', function(e) {
        ScreenDetector.launch();
    }, false);
})();

function setLogoImage(imageString){
    var logoEl = document.getElementById("source_icon");
    try{
        if(!imageString){
            logoEl.style.display = 'none';
            logoEl.style.marginLeft = '0px';
            return false;
        }
//        logoEl.style.position = 'bottom '
        logoEl.src = imageString;
    }catch(e){
        logoEl.style.display = 'none';
        logoEl.style.marginLeft = '0px';
    }

}

function initAudio(){
    var container = document.getElementById('content');
    var audioComponent = container.getElementsByClassName('audio');
    for(var i=0;i<audioComponent.length;i++){
        var audioDom = audioComponent[i];
        //audioDom.clientHeight，getleft(audioDom)获取的值在低版本（4.4以下）中是错误的
        //为了兼容低版本手机控件高度写死为60，左边距15；
        ifeng.initAudioLayout(window.devicePixelRatio*60,window.devicePixelRatio*15, window.devicePixelRatio*(getTop(audioDom)+10),audioDom.getAttribute('title'),audioDom.getAttribute('desc'),audioDom.getAttribute('duration'),audioDom.getAttribute('srcNor'),audioDom.getAttribute('srcHD'),audioDom.getAttribute('guid'),audioDom.getAttribute('columnId'));
    }
}

/*
*  民调广告的显示控制
*/
function setSurveyAd(src) {
   var surveyAdWrapper = document.getElementById('survey_ad_wrapper');
   var image = document.getElementById('survey_ad_img');
   if (src == '') {
      surveyAdWrapper.style.display = 'none';
      image.style.display = 'none';
   } else {
      surveyAdWrapper.style.display = 'block';
      image.style.display = 'block';
      image.src = src;
   }
};

/*
*  正文广告的显示控制
*/
function setBodyAd(src) {
     var bodyAdImage = document.getElementById('body_ad_img');
     bodyAdImage.innerHTML = '';
     if (src == 'none') {
          bodyAdImage.style.backgroundImage = 'url(slide_text.png),url(logo_no_load.png)';
     } else {
          bodyAdImage.style.backgroundImage = 'url(' + src + ')';
     }
}


//处理自媒体商品占位符
function handle_zmt_goods_position(content,flag_p, item) {
    var list = getContentPosition(content, flag_p),
        length = list.length,
        flag_p_length = flag_p.length;
    if(length>0) {
        var i,j,temp_sum;
        content = content.replace(new RegExp(flag_p,"gm"),"");
        for(i=0;i<length;i++) {
            list[i]-=flag_p_length*i;
        }
        for(j=0,temp_sum=0;j<length;j++) {
            var item_str = item;
            if (!item_str || Object.prototype.toString.call(item_str) !== '[object String]') {
                continue;
            }
            content = insertStr(content, item_str, temp_sum+list[j]);
            temp_sum+=item_str.length;
        }
    }
    return content;
}

 function show_content(content) {
        document.getElementById("content").innerHTML = content;
    }
