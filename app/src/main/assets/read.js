    function handle_img(){
        var imgs = document.getElementsByTagName("img");
        var img_url_data = "";
        for (var i = 0 ; i < imgs.length ; i++){
            img_url_data += imgs[i].src + "|";
        }
        for (var i = 0 ; i < imgs.length ; i++){
            imgs[i].onclick = (function(index){
                return function(){
                    window.article.showImg(index, img_url_data);
                }
            })(i + "");
        }
    }

    function show_content(content) {
        document.getElementById("main_content").innerHTML = content;

        var ems = document.getElementsByTagName("em");
        for (var i = 0 ; i < ems.length ; i++){
            ems[i].style.color = "#737373";
        }

        var as = document.getElementsByTagName("a");
        for (var i = 0 ; i < as.length ; i++){
            as[i].style.color = "#FF0000";
        }

        var iframes = document.getElementsByTagName("iframe");
        for (var i = 0 ; i < iframes.length ; i++){
            iframes[i].width = '100%';
            iframes[i].height = '100%';
        }

        var quotes = document.getElementsByTagName("blockquote");
        for (var i = 0 ; i < quotes.length ; i++){
            quotes[i].style.borderColor = "#D6D6D6";
            quotes[i].style.backgroundColor = "#F2F2F2";
        }

        handle_img();
    }

    function change_trick_space_height(height) {
		document.getElementById('trick_space').style.height = height + 'px';
	}
