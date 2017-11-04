/**
 * 图片裁剪规则实现
 */
var ImageCropper = function(strategy) {
	this._strategy = strategy;
}
ImageCropper.prototype = {
	getResult: function(width, height) {
		return this._strategy.getResult(width, height);
	}		
};

//根据标准宽和传入的宽高获得标准高
var StandPlaceholderCropStrategy = function(stdWidth) {
	this._stdWidth = stdWidth;
};

StandPlaceholderCropStrategy.prototype = {
	getResult: function(width, height) {
		var ratio = this._stdWidth / width;

		return {
			width: this._stdWidth,
			height:Math.round(height * ratio)
		};
	}
};