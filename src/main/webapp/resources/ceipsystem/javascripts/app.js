$(document).ready(function(){ /*Quando o documento tiver carregado chame a funcao*/
	
	/*Com o compomente de calsse js-toggle
	 * ouvindo (bind) um click, chame a funcao
	 * 
	 * */
	$('.js-toggle').bind('click', function(){ 
		$('.js-sidebar').toggleClass('is-toggle'); /*se o componente tiver is-toggle, tira, senao tiver coloca*/
		$('.js-content').toggleClass('is-toggle');
		$('#mn').toggleClass('fa-angle-double-left');
		
	});
	
});