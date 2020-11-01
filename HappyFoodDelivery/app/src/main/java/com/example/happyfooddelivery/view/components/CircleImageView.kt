package com.example.happyfooddelivery.view.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.example.happyfooddelivery.R

class CircleImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var radius = 0f
    private val path = Path()

    init {
        context.withStyledAttributes(attrs, R.styleable.CircleImageView){
            radius = getDimension(R.styleable.CircleImageView_cornerRadius, 0f)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val circle = RectF(0f, 0f, width.toFloat(), height.toFloat())
        path.addRoundRect(circle, radius, radius, Path.Direction.CCW)
        canvas?.clipPath(path)
        super.onDraw(canvas)

    }
}