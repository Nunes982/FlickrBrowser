package andersonnunes.exemplo.flickrbrowser

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class PhotoDetailsActivity : BaseActivity() {
    private val TAG = "PhotoDetailsActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_details)

        activateToolbar(true)

//        val photo = intent.getSerializableExtra(PHOTO_TRANSFER) as Photo
        val photo = intent.extras?.getParcelable<Photo>(PHOTO_TRANSFER) as Photo

        var photoTitle = findViewById<TextView>(R.id.photo_title)
        var photoTags = findViewById<TextView>(R.id.photo_tags)
        var photoAuthor = findViewById<TextView>(R.id.photo_author)
        var photoImage = findViewById<ImageView>(R.id.photo_image)

//        photoTitle.text = "Title: " + photo.title
        photoTitle.text = resources.getString(R.string.photo_title_text, photo.title)
//        photoTags.text = "Tags: " + photo.tags
        photoTags.text = resources.getString(R.string.photo_tags_text, photo.tags)
        photoAuthor.text = photo.author
//        photoAuthor.text = resources.getString(R.string.photo_author_text, "my", "red", "car")

        Picasso.get().load(photo.link)
            .error(R.drawable.placeholder)
            .placeholder(R.drawable.placeholder)
            .into(photoImage)


//        photoTitle.text = photo.title
    }

}