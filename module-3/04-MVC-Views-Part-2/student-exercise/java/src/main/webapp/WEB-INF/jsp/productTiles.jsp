<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Tile View" />
</c:import>

<div id="masonry-page">
	<c:import url="/WEB-INF/jsp/common/filters.jsp">
		<%-- Modify the baseRoute to apply filters to the current route. --%>
		<c:param name="baseRoute" value="#" />
	</c:import>

	<!-- Container for all of the Products -->
	<!-- The list of products is available using the `products` variable -->
	<div id="grid" class="main-content">

		<!-- The following HTML shows different examples of what HTML
		 could be rendered based on different rules. For purposes
		 of demonstration we've written it out so you can see it
		 when you load the page up. -->

		<!-- Standard Product -->
		<c:forEach var="product" items="${products}">
			<c:choose>
				<c:when test="${product.topSeller}">
					<!-- Add the .top-seller class if the product is considered a Top Seller -->
					<div class="tile top-seller ${product.remainingStock == 0 ? 'sold-out': 'tile top-seller'}">
						<c:if test= "${product.remainingStock == 0}">
								<span class="banner">Sold Out</span>
						</c:if>

						<!-- Link to the Detail page using the product id (e.g. products/detail?id=1) -->
						<a class="product-image" href="detail?id=${product.id}">
							<img src="<c:url value="/images/product-images/${product.imageName}" />" />
						</a>
						<div class="details">
							<p class="name">
								<a href="#">${product.name}</a>
							</p>

							<!-- .filled will make the star solid -->
							<c:if test ="${product.averageRating < 1.5}">
								<div class="rating">
									<span class="filled">&#9734;</span>
									<span>&#9734;</span>
									<span>&#9734;</span>
									<span>&#9734;</span>
									<span>&#9734;</span>
								</div>
							</c:if>
							<c:if test ="${product.averageRating >= 1.5 && product.averageRating < 2.5}">
								<div class="rating">
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span>&#9734;</span>
									<span>&#9734;</span>
									<span>&#9734;</span>
								</div>
							</c:if>
							<c:if test ="${product.averageRating >= 2.5 && product.averageRating < 3.5}">
								<div class="rating">
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span>&#9734;</span>
									<span>&#9734;</span>
								</div>
							</c:if>
							<c:if test ="${product.averageRating >= 3.5 && product.averageRating < 4.5}">
								<div class="rating">
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span>&#9734;</span>
								</div>
							</c:if>
							<c:if test ="${product.averageRating >= 4.5}">
								<div class="rating">
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
									<span class="filled">&#9734;</span>
								</div>
							</c:if>
							<br />
							<p class="product-alert">Top Seller</p>
							<c:if test ="${product.remainingStock > 0 && product.remainingStock <= 5}">
								<span class="product-alert">Only ${product.remainingStock} left!</span>
							</c:if>
							<p class="price">${product.price}</p>
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="tile ${product.remainingStock == 0 ? 'sold-out': 'tile'}">
						<c:choose>
							<c:when test= "${product.remainingStock == 0}">
								<span class="banner">Sold Out</span>
							</c:when>
							<c:when test="${product.topSeller}">
								<span class="banner top-seller">Top Seller!</span>
							</c:when>
						</c:choose>

						<a class="product-image" href="detail?id=${product.id}">
							<img src="<c:url value="/images/product-images/${product.imageName}" />" />
						</a>
						<div class="details">
							<p class="name">
								<a href="#">${product.name}</a>
							</p>

							<!-- .filled will make the star solid -->
							<c:choose>
								<c:when test ="${product.averageRating < 1.5}">
									<div class="rating">
										<span class="filled">&#9734;</span>
										<span>&#9734;</span>
										<span>&#9734;</span>
										<span>&#9734;</span>
										<span>&#9734;</span>
									</div>
								</c:when>
								<c:when test ="${product.averageRating >= 1.5 && product.averageRating < 2.5}">
									<div class="rating">
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span>&#9734;</span>
										<span>&#9734;</span>
										<span>&#9734;</span>
									</div>
								</c:when>
								<c:when test ="${product.averageRating >= 2.5 && product.averageRating < 3.5}">
									<div class="rating">
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span>&#9734;</span>
										<span>&#9734;</span>
									</div>
								</c:when>
								<c:when test ="${product.averageRating >= 3.5 && product.averageRating < 4.5}">
									<div class="rating">
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span>&#9734;</span>
									</div>
								</c:when>
								<c:otherwise>
									<div class="rating">
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
										<span class="filled">&#9734;</span>
									</div>
								</c:otherwise>
							</c:choose>
							<c:if test ="${product.remainingStock > 0 && product.remainingStock <= 5}">
								<span class="product-alert">Only ${product.remainingStock} left!</span>
							</c:if>
							<p class="price">${product.price}</p>

						</div>
					</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />