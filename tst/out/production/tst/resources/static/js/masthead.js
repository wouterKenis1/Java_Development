 $(function() {
    $('.scroll-down').click (function() {
      $('html, body').animate({scrollTop: $('section.py-5').offset().top }, 'slow');
      return false;
    });
  });