!function(a){var b={init:function(b){var c={direction:"left",loop:-1,scrolldelay:0,scrollamount:50,circular:!0,drag:!0,runshort:!0,hoverstop:!0,inverthover:!1,xml:!1};return b&&a.extend(c,b),this.each(function(){var e,f,g,h,i,j,k,l,m,n,b="mouseenter",d="mouseleave";if(c.inverthover&&(b="mouseleave",d="mouseenter"),e=c.loop,f=a(this).addClass("str_wrap").data({scrollamount:c.scrollamount}),g=!1,h=f.attr("style"))for(i=h.split(";"),j=!1,k=0;k<i.length;k++)l=a.trim(i[k]),m=l.search(/^height/g),-1!=m&&(j=parseFloat(f.css("height")));n=function(){var h,i,j,k,l,m,n,o,p,q,r,s,t,u,v;f.off("mouseleave"),f.off("mouseenter"),f.off("mousemove"),f.off("mousedown"),f.off("mouseup"),a(".str_move",f).length||f.wrapInner(a("<div>").addClass("str_move")),h=a(".str_move",f).addClass("str_origin"),i=h.clone().removeClass("str_origin").addClass("str_move_clone"),j=0,c.hoverstop||f.addClass("noStop"),k=function(){i.clone().css({left:"100%",right:"auto",width:h.width()}).appendTo(h),i.css({right:"100%",left:"auto",width:h.width()}).appendTo(h)},l=function(){i.clone().css({top:"100%",bottom:"auto",height:h.height()}).appendTo(h),i.css({bottom:"100%",top:"auto",height:h.height()}).appendTo(h)},"left"==c.direction&&(f.height(h.outerHeight()),h.width()>f.width()?(m=-h.width(),c.circular&&(c.xml||(k(),m=-(h.width()+(h.width()-f.width())))),c.xml&&h.css({left:f.width()}),n=f.width(),o=0,p=function(){var a=Math.abs(m),b=1e3*(a/f.data("scrollamount"));return 0!=parseFloat(h.css("left"))&&(a+=f.width(),b=1e3*((a-(f.width()-parseFloat(h.css("left"))))/f.data("scrollamount"))),b},q=!1,r=function(){0!=e&&h.stop(!0).animate({left:m},p(),"linear",function(){a(this).css({left:f.width()}),-1==e?q=setTimeout(r,c.scrolldelay):(e--,q=setTimeout(r,c.scrolldelay))})},f.data({moveId:q,moveF:r}),c.inverthover||r(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),clearTimeout(q),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),r()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientX,n=h.position().left,o=n-(b.clientX-f.offset().left),a(this).on("mousemove",function(a){g=!0,i=a.clientX,e=i>j?1:-1,j=i,d=o+(a.clientX-f.offset().left),c.circular?(d<-h.width()&&0>e&&(d=0,n=h.position().left,o=n-(a.clientX-f.offset().left)),d>0&&e>0&&(d=-h.width(),n=h.position().left,o=n-(a.clientX-f.offset().left))):(d<-h.width()&&0>e&&(d=f.width(),n=h.position().left,o=n-(a.clientX-f.offset().left)),d>f.width()&&e>0&&(d=-h.width(),n=h.position().left,o=n-(a.clientX-f.offset().left))),h.stop(!0).css({left:d})}).on("mouseup",function(){a(this).off("mousemove"),c.inverthover&&h.trigger("mouseenter"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):c.runshort?(h.css({left:f.width()}),n=f.width(),o=0,s=function(){return j=1e3*((h.width()+h.position().left)/f.data("scrollamount"))},t=function(){var b=-h.width();h.animate({left:b},s(),"linear",function(){a(this).css({left:f.width()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientX,n=h.position().left,o=n-(b.clientX-f.offset().left),a(this).on("mousemove",function(a){g=!0,i=a.clientX,e=i>j?1:-1,j=i,d=o+(a.clientX-f.offset().left),d<-h.width()&&0>e&&(d=f.width(),n=h.position().left,o=n-(a.clientX-f.offset().left)),d>f.width()&&e>0&&(d=-h.width(),n=h.position().left,o=n-(a.clientX-f.offset().left)),h.stop(!0).css({left:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):f.addClass("str_static")),"right"==c.direction&&(f.height(h.outerHeight()),f.addClass("str_right"),h.css({left:-h.width(),right:"auto"}),h.width()>f.width()?(m=f.width(),h.css({left:0}),c.circular&&(c.xml||(k(),m=h.width())),u=0,s=function(){var a=f.width(),b=1e3*(a/f.data("scrollamount"));return 0!=parseFloat(h.css("left"))&&(a=h.width()+f.width(),b=1e3*((a-(h.width()+parseFloat(h.css("left"))))/f.data("scrollamount"))),b},t=function(){0!=e&&h.animate({left:m},s(),"linear",function(){a(this).css({left:-h.width()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientX,n=h.position().left,u=n-(b.clientX-f.offset().left),a(this).on("mousemove",function(a){g=!0,i=a.clientX,e=i>j?1:-1,j=i,d=u+(a.clientX-f.offset().left),c.circular?(d<-h.width()&&0>e&&(d=0,n=h.position().left,u=n-(a.clientX-f.offset().left)),d>0&&e>0&&(d=-h.width(),n=h.position().left,u=n-(a.clientX-f.offset().left))):(d<-h.width()&&0>e&&(d=f.width(),n=h.position().left,u=n-(a.clientX-f.offset().left)),d>f.width()&&e>0&&(d=-h.width(),n=h.position().left,u=n-(a.clientX-f.offset().left))),h.stop(!0).css({left:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):c.runshort?(u=0,s=function(){return j=1e3*((f.width()-h.position().left)/f.data("scrollamount"))},t=function(){var b=f.width();h.animate({left:b},s(),"linear",function(){a(this).css({left:-h.width()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientX,n=h.position().left,u=n-(b.clientX-f.offset().left),a(this).on("mousemove",function(a){g=!0,i=a.clientX,e=i>j?1:-1,j=i,d=u+(a.clientX-f.offset().left),d<-h.width()&&0>e&&(d=f.width(),n=h.position().left,u=n-(a.clientX-f.offset().left)),d>f.width()&&e>0&&(d=-h.width(),n=h.position().left,u=n-(a.clientX-f.offset().left)),h.stop(!0).css({left:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):f.addClass("str_static")),"up"==c.direction&&(f.addClass("str_vertical"),h.height()>f.height()?(v=-h.height(),c.circular&&(c.xml||(l(),v=-(h.height()+(h.height()-f.height())))),c.xml&&h.css({top:f.height()}),u=0,s=function(){var a=Math.abs(v),b=1e3*(a/f.data("scrollamount"));return 0!=parseFloat(h.css("top"))&&(a+=f.height(),b=1e3*((a-(f.height()-parseFloat(h.css("top"))))/f.data("scrollamount"))),b},t=function(){0!=e&&h.animate({top:v},s(),"linear",function(){a(this).css({top:f.height()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientY,strMoveTop=h.position().top,u=strMoveTop-(b.clientY-f.offset().top),a(this).on("mousemove",function(a){g=!0,i=a.clientY,i>j?e=1:j>i&&(e=-1),j=i,d=u+a.clientY-f.offset().top,c.circular?(d<-h.height()&&0>e&&(d=0,strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),d>0&&e>0&&(d=-h.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top))):(d<-h.height()&&0>e&&(d=f.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),d>f.height()&&e>0&&(d=-h.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top))),h.stop(!0).css({top:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):c.runshort?(h.css({top:f.height()}),u=0,s=function(){return j=1e3*((h.height()+h.position().top)/f.data("scrollamount"))},t=function(){var b=-h.height();h.animate({top:b},s(),"linear",function(){a(this).css({top:f.height()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientY,strMoveTop=h.position().top,u=strMoveTop-(b.clientY-f.offset().top),a(this).on("mousemove",function(a){g=!0,i=a.clientY,i>j?e=1:j>i&&(e=-1),j=i,d=u+a.clientY-f.offset().top,d<-h.height()&&0>e&&(d=f.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),d>f.height()&&e>0&&(d=-h.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),h.stop(!0).css({top:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):f.addClass("str_static")),"down"==c.direction&&(f.addClass("str_vertical").addClass("str_down"),h.css({top:-h.height(),bottom:"auto"}),h.height()>f.height()?(v=f.height(),c.circular&&(c.xml||(l(),v=h.height())),c.xml&&h.css({top:-h.height()}),u=0,s=function(){var a=f.height(),b=1e3*(a/f.data("scrollamount"));return 0!=parseFloat(h.css("top"))&&(a=h.height()+f.height(),b=1e3*((a-(h.height()+parseFloat(h.css("top"))))/f.data("scrollamount"))),b},t=function(){0!=e&&h.animate({top:v},s(),"linear",function(){a(this).css({top:-h.height()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientY,strMoveTop=h.position().top,u=strMoveTop-(b.clientY-f.offset().top),a(this).on("mousemove",function(a){g=!0,i=a.clientY,i>j?e=1:j>i&&(e=-1),j=i,d=u+a.clientY-f.offset().top,c.circular?(d<-h.height()&&0>e&&(d=0,strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),d>0&&e>0&&(d=-h.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top))):(d<-h.height()&&0>e&&(d=f.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),d>f.height()&&e>0&&(d=-h.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top))),h.stop(!0).css({top:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):c.runshort?(u=0,s=function(){return j=1e3*((f.height()-h.position().top)/f.data("scrollamount"))},t=function(){var b=f.height();h.animate({top:b},s(),"linear",function(){a(this).css({top:-h.height()}),-1==e?setTimeout(t,c.scrolldelay):(e--,setTimeout(t,c.scrolldelay))})},f.data({moveF:t}),c.inverthover||t(),c.hoverstop&&(f.on(b,function(){a(this).addClass("str_active"),h.stop(!0)}).on(d,function(){a(this).removeClass("str_active"),a(this).off("mousemove"),t()}),c.drag?f.on("mousedown",function(b){var d,e,i,j;return c.inverthover&&h.stop(!0),e=1,j=b.clientY,strMoveTop=h.position().top,u=strMoveTop-(b.clientY-f.offset().top),a(this).on("mousemove",function(a){g=!0,i=a.clientY,i>j?e=1:j>i&&(e=-1),j=i,d=u+a.clientY-f.offset().top,d<-h.height()&&0>e&&(d=f.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),d>f.height()&&e>0&&(d=-h.height(),strMoveTop=h.position().top,u=strMoveTop-(a.clientY-f.offset().top)),h.stop(!0).css({top:d})}).on("mouseup",function(){c.inverthover&&h.trigger("mouseenter"),a(this).off("mousemove"),setTimeout(function(){g=!1},50)}),!1}).on("click",function(){return g?!1:void 0}):f.addClass("no_drag"))):f.addClass("str_static"))},c.xml?a.ajax({url:c.xml,dataType:"xml",success:function(b){var g,h,i,j,d=a(b).find("text"),e=d.length;for(g=0;e>g;g++)h=d.eq(g),i=h.text(),j=a("<span>").text(i).appendTo(f),("left"==c.direction||"right"==c.direction)&&(j.css({display:"inline-block",textAlign:"right"}),g>0&&j.css({width:f.width()+j.width()})),("down"==c.direction||"up"==c.direction)&&(j.css({display:"block",textAlign:"left"}),g>0&&j.css({paddingTop:f.height()}));n()}}):n(),f.data({ini:n,startheight:j})})},update:function(){var b=a(this),c=a(".str_origin",b),d=a(".str_move_clone",b);c.stop(!0),d.remove(),b.data("ini")()},destroy:function(){var e,f,g,h,i,j,k,l,b=a(this),c=a(".str_move",b),d=b.data("startheight");if(a(".str_move_clone",b).remove(),b.off("mouseenter"),b.off("mousedown"),b.off("mouseup"),b.off("mouseleave"),b.off("mousemove"),b.removeClass("noStop").removeClass("str_vertical").removeClass("str_active").removeClass("no_drag").removeClass("str_static").removeClass("str_right").removeClass("str_down"),e=b.attr("style")){for(f=e.split(";"),g=0;g<f.length;g++)h=a.trim(f[g]),i=h.search(/^height/g),-1!=i&&(f[g]="");j=f.join(";"),k=j.replace(/;+/g,";"),";"==k?b.removeAttr("style"):b.attr("style",k),d&&b.css({height:d})}c.stop(!0),c.length&&(l=c.html(),c.remove(),b.html(l))},pause:function(){var b=a(this),c=a(".str_move",b);c.stop(!0)},play:function(){var b=a(this);a(this).off("mousemove"),b.data("moveF")()}};a.fn.liMarquee=function(c){return b[c]?b[c].apply(this,Array.prototype.slice.call(arguments,1)):"object"!=typeof c&&c?(a.error("Метод "+c+" в jQuery.liMarquee не существует"),void 0):b.init.apply(this,arguments)}}(jQuery);