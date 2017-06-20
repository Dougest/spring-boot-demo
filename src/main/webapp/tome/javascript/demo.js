$(document).ready(function() {
  
  //Initiliaze
  itemShow         = 16;
  indexedItemShow  = itemShow - 1
  itemList         = $('#portfolio-item');
  itemWrapper      = $('#portfolio');
  rotation         = ['flipped-vertical-bottom', 'flipped-vertical-top', 'flipped-horizontal-left', 'flipped-horizontal-right'];
  navigation       = $('#navigation a');

  //Populate items
  for( var i = 0; i < itemShow; i++ ) {
  
    itemImage    = itemList.children('li:eq(' + i + ')').children('img');
    itemSrc      = itemImage.attr('src');
    itemAlt      = itemImage.attr('alt');
    item         = '<div style="background:url(' + itemSrc + ')"> <span>' + itemAlt + '</span></div>';
    itemWrapper.append(item);
  }
  
  timer1=setTimeout(function(){
   random  = Math.floor( Math.random() * ( 3 - 0 + 1 ) );
   transform(random);

   },10000);

  function transform() {
   var  page  = Math.floor( Math.random() * ( 2 - 0 + 1 ) );
    //e.preventDefault();
    //navigation.removeClass('selected');
    //$(this).addClass('selected');
    //page = $(this).attr('data-page');
    for( var i = 0; i <= indexedItemShow; i++ ) {

      random     = Math.floor( Math.random() * ( 3 - 0 + 1 ) );
      animation  = rotation[random];
      
      item       = itemWrapper.children('div:eq(' + i + ')');

      item.addClass('animated ' + animation);
       window.setTimeout(function (index) {
        return function () {
          indexReal    = (page == 1) ? index : (index + (page - 1)) ;
          itemHost     = indexReal + (indexedItemShow * (page - 1));
          itemImage    = itemList.children('li:eq(' + itemHost + ')').children('img');
          itemSrc      = itemImage.attr('src');
          itemAlt      = itemImage.attr('alt');
          itemCurrent  = itemWrapper.children('div:eq(' + index + ')');
          itemCurrent.css('background', 'url(' + itemSrc + ')');
          itemCurrent.children('span').text(itemAlt);
        };
      }(i), 10000);
      //window.clearTimeout(timer1);
      //eval(setTimeout('leftScroll()',5000));
      item.on('transitionend webkitTransitionEnd MSTransitionEnd oTransitionEnd', function() { 
        $(this).removeClass();
      });
      timer2 = setTimeout(function(){
        window.clearTimeout(timer1);
        random     = Math.floor( Math.random() * ( 3 - 0 + 1 ) );
        transform(random);
      },10000);

    }
  }
});