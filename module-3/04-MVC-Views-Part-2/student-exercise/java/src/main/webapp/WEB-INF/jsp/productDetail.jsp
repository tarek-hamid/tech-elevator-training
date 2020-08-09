<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:import url="/WEB-INF/jsp/common/header.jsp">
	<c:param name="pageTitle" value="Product Details" />
</c:import>

<!-- Container for the Product -->
<!-- The current product is available using the `product` variable -->
<div id="product-detail">
	<img src="<c:url value="/images/product-images/${product.imageName}" />" />
	<div class="product-description">
		<h3>${product.name}</h3>

		<!-- .filled will make the star solid -->

		<%--		Trying to get average rating in a single for loop--%>
		<%--		<c:set var="averageRating" value="${Math.round(product.averageRating)}"/>
                <c:forEach begin="1" end="5">
                    <c:choose>
                        <c:when test="${averageRating > 0}">
                            <div class="rating">
                                <span class="filled">&#9734;</span>
                            </div>
                            <c:set var="averageRating" value="${product.averageRating-1}"/>
                        </c:when>
                        <c:otherwise>
                            <div class="rating">
                                <span>&#9734;</span>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>--%>

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

		<!-- Include this if the product has a Remaining Stock of 5 or less -->
		<c:if test="${product.remainingStock <= 5 && product.remainingStock > 0}">
			<p class="alert-remaining">BUY NOW! Only ${product.remainingStock} left!</p>
		</c:if>
		<p class="description">${product.description}</p>
		<p class="price">${product.price}</p>

		<!-- If item is in stock -->
		<c:choose>
			<c:when test = "${product.remainingStock > 0}">
				<button class="action">Add to Cart</button>
			</c:when>
			<c:otherwise>
				<button disabled>Sold Out</button>
			</c:otherwise>
		</c:choose>

	</div>
</div>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />