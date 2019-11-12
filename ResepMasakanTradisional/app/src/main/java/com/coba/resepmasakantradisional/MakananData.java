package com.coba.resepmasakantradisional;

import java.util.ArrayList;

public class MakananData {
    private static int[] IdMakanan = {
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
    };
    private static String[] NamaMakanan = {
            "Lumpia",
            "Tahu Petis",
            "Mendoan",
            "Enting-enting Gepuk",
            "Getuk",
            "Wajik",
            "Dawet Ireng",
            "Garang Asem",
            "Tiwul",
            "Serabi"
    };

    private static String[] DeskripsiMakanan = {
            "Lumpia adalah salah satu makanan khas Jawa Tengah yang sudah sangat terkenal. Asal makanan ini memang dari Semarang meskipun kini sudah banyak menyebar di daerah lainnya. Camilan khas ini dibuat dengan menggunakan tepung terigu yang dibentuk menjadi kulit. Setelah itu, kulit tersebut akan membungkus beberapa pilihan isi lumpia, seperti sayuran, udang, telur dan ayam. Menikmati lumpia yang hangat lengkap dengan cabai rawit yang pedas pasti akan sangat menggugah selera!",
            "Tahu petis adalah salah satu makanan khas Jawa Tengah yang juga cukup terkenal dan populer di berbagai kalangan masyarakat. Seperti namanya, makanan khas ini adalah paduan dari tahu dan petis. Nah, panganan ini dibuat dengan bahan dasar tahu pong. Setelah itu, tahu digoreng hingga cukup kering. Kemudian, dalam penyajiannya, tahu akan disiram dengan saus petis yang berwarna hitam. Selain disiram, beberapa penjual makanan khas Jawa Tengah ini menggunakan petis sebagai isian tahu. ",
            "Mendoan masuk dalam salah satu gorengan paling terkenal di Indonesia. Namun, sebenarnya, gorengan legendaris ini berasal dari Jawa Tengah. Ya, awalnya, makanan khas Jawa Tengah ini banyak ditemukan di daerah Purwokerto dan Banyumas. Di daerah tersebut, mendoan memang disebut dengan nama yang berbeda, salah satunya adalah tempe kemul. Jika Anda berkunjung ke daerah ini, maka akan banyak penjual mendoan yang menjajakan dagangannya. Bahkan, ada produksi tempe khusus untuk mendoan yang siap pakai. ",
            "Enting-enting adalah salah satu makanan khas Jawa Tengah yang cukup populer. Makanan ini dibuat dengan bahan dasar kacang tanah yang dicampur dengan gula jawa dan dipadatkan. Rasa kacang dan manis dari gula menyatu dengan sangat sempurna yang membuat camilan ini terasa begitu nikmat. Nah, makanan khas Jawa Tengah ini dulunya berasal dari daerah Salatiga. Namun, kini Anda sudah cukup mudah menemukannya. Hal ini dikarenakan enting-enting sudah tersebar di berbagai daerah dan biasanya menghiasi etalase toko oleh-oleh.",
            "Getuk sudah banyak ditemukan di berbagai daerah, bahkan di luar Jawa Tengah. Namun, awalnya, makanan ini muncul di daerah Jawa Tengah sehingga menjadi salah satu makanan khas Jawa Tengah hingga kini. Pada mulanya, getuk muncul dengan warna putih saja. Namun, kini, camilan dengan bahan dasar singkong ini muncul dengan beragam variasi yang berbeda. Getuk yang diberi tambahan kelapa muda parut memiliki rasa yang cukup manis dan sangat gurih sehingga cocok untuk camilan bersama dengan teh hangat.",
            "Wajik termasuk salah satu yang masih ada meskipun termasuk panganan yang tradisional. Ya, hal ini dikarenakan wajik sudah muncul sejak zaman dahulu, namun bisa bertahan diantara gerusan makanan modern karena rasanya yang khas. Camilan ini dibuat dengan bahan dasar beras ketan yang dimasak dengan campuran gula jawa. Nah, karena campurannya ini maka wajik dulunya muncul dengan warna cokelat. Namun, kini makanan khas Jawa Tengah ini muncul dengan aneka warna yang lebih menarik. Untuk produk yang satu ini, wajik dibuat dengan bahan gula pasir.",
            "Dawet ireng adalah salah satu sajian khas dari Jawa Tengah yang berasal dari Kota Purworejo. Seperti namanya, apa yang menarik dari minuman dawet ini adalah warnanya yang hitam. Warna hitam dari dawet ini berasal dari bahan alami yang digunakan, yakni abu jerami. Bahan tersebut ditambahkan pada saat proses pembuatan cendol. Rasa dawet ini begitu nikmat dan manis. Menikmati dawet ireng di siang hari yang panas pasti akan sangat menyegarkan.",
            "Garang asem dibuat dengan bahan dasar daging ayam. Nah, apa yang menarik dari makanan ini adalah daging ayam diolah dengan santan, asam dan cabai. Ketika matang, Anda akan merasakan olahan daging yang unik dan lezat. Dalam penyajiannya, kuliner khas Jawa Tengah ini disajikan dengan daun pisang sehingga terlihat lebih tradisional. Sajian kuliner yang satu ini cukup mudah ditemukan di beberapa kabupaten di Jawa Tengah, seperti Kudus, Semarang, Pati, Demak dan juga Pekalongan.",
            "Tiwul merupakan makanan khas dari Jawa Tengah yang bisa dianggap sebagai panganan tradisional. Ya, makanan khas Jawa Tengah ini sudah ada sejak zaman dahulu kala. Camilan ini terbuat dari singkong yang diolah dan ditambahkan dengan parutan kelapa muda. Nah, tiwul cukup mudah ditemukan di daerah Wonogiri.",
            "Serabi adalah salah satu makanan yang sangat terkenal dengan teksturnya yang lembut dan rasanya yang cenderung manis. Namun, meskipun sudah banyak ditemukan di mana saja, Jawa Tengah memiliki salah satu serabi yang unik dan wajib Anda coba: serabi Notosuman. Ya, serabi ini menjadi makanan khas Jawa Tengah yang sangat terkenal. Serabi ini dibuat dengan bahan tepung beras, santan, gula, daun pandan dan garam."
    };

    private static int[] FotoMakanan = {
            R.drawable.lumpia,
            R.drawable.tahu_petis,
            R.drawable.mendoan,
            R.drawable.enting_enting_gepuk,
            R.drawable.getuk,
            R.drawable.wajik,
            R.drawable.dawet_ireng,
            R.drawable.garang_asem,
            R.drawable.tiwul,
            R.drawable.serabi
    };

    static ArrayList<Makanan> getListData(){
        ArrayList<Makanan> list = new ArrayList<>();
        for (int position = 0; position < NamaMakanan.length; position++){
            Makanan makanan = new Makanan();
            makanan.setId(IdMakanan[position]);
            makanan.setName(NamaMakanan[position]);
            makanan.setDescription(DeskripsiMakanan[position]);
            makanan.setPhoto(FotoMakanan[position]);
            list.add(makanan);
        }
        return list;
    }
}
