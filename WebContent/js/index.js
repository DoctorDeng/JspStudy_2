$('.aaa').jqPaginator(
		{
			totalPages:4,
			viiblePages:3,
			currentPage: 1,
			onPageChange: function(num, type) {
				$('.aaa').html('当前第' + num + '页');
			}
		})