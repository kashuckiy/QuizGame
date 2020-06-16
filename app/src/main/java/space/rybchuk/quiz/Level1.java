package space.rybchuk.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.logging.Level;

public class Level1 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;
    public int numLeft; // переменная для левой картинки + текст
    public int numRight; // переменная для левой картинки + текст
    Array array = new Array();
    Random random = new Random();
    public int count= 0;//Лічильник правильних відповідей


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        //Створюємо змінну text_levels
        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level1);//Установили текст

        /* Код яуий скругляє краї лівої картинки*/
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        img_left.setClipToOutline(true);

        /* Код яуий скругляє краї правої картинки*/
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        img_right.setClipToOutline(true);

        /*Путь до лівої TextView*/
        final TextView text_left = findViewById(R.id.text_left);
        /*Путь до правої TextView*/
        final TextView text_right = findViewById(R.id.text_right);

        /*Розвернути гру на весь екран, скрити статус бар*/
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        /*Виклик діалогового вікна на початку гри початок*/
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);// Скриваємо заголовок діалогового вікна
        dialog.setContentView(R.layout.previewdialog);//шлях до макету діалогового вікна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозразний фон діалогового вікна
        dialog.setCancelable(false);//Вікно не можна закрити системною кнопкою "назад"

        /*Кнопка яка закриває діалогове вікно початок*/
        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose) ;
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Оброботка нажаття кнопки початок*/
                try {
                    /*Вернутися назад до вибору рівня початок*/
                    Intent intent = new Intent(Level1.this, GameLevels.class);//Створення наміру перехода
                    startActivity(intent);//Старт наміру
                    finish();// Закрити цей клас
                    /*Вернутися назад до вибору рівня кінець*/
                }catch (Exception e){

                }
                dialog.dismiss();//Закриваємо діалогове вікно
                /*Оброботка нажаття кнопки кінець*/
            }
        });
        /*Кнопка яка закриває діалогове вікно кінець*/

        /*Кнопка "ПРОДОВЖИТИ" початок*/
        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//Коли користувач нажимає кнопку "ПРОДОВЖИТИ" діалогове вікно закривається
            }
        });
        /*Кнопка "ПРОДОВЖИТИ" кінець*/

        dialog.show();//Показати діалогове вікно

        /*_________________________________________*/
        /*Виклик діалогового вікна в кінці гри початок*/
        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);// Скриваємо заголовок діалогового вікна
        dialogEnd.setContentView(R.layout.dialogend);//шлях до макету діалогового вікна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//Прозразний фон діалогового вікна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);//Діалогове вікно на весь екран
        dialogEnd.setCancelable(false);//Вікно не можна закрити системною кнопкою "назад"

        /*Кнопка яка закриває діалогове вікно початок*/
        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose) ;
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Оброботка нажаття кнопки початок*/
                try {
                    /*Вернутися назад до вибору рівня початок*/
                    Intent intent = new Intent(Level1.this, GameLevels.class);//Створення наміру перехода
                    startActivity(intent);//Старт наміру
                    finish();// Закрити цей клас
                    /*Вернутися назад до вибору рівня кінець*/
                }catch (Exception e){

                }
                dialogEnd.dismiss();//Закриваємо діалогове вікно
                /*Оброботка нажаття кнопки кінець*/
            }
        });
        /*Кнопка яка закриває діалогове вікно кінець*/

        /*Кнопка "ПРОДОВЖИТИ" початок*/
        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level1.this, Level2.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();//Коли користувач нажимає кнопку "ПРОДОВЖИТИ" діалогове вікно закривається
            }
        });
        /*Кнопка "ПРОДОВЖИТИ" кінець*/

        /*_________________________________________*/

        /*Кнопка "Назад" початок*/
        Button btn_back = (Button)findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Оброботка нажаття кнопки "Назад" початок*/
                try {
                    /*Вернутися назад до вибору рівня початок*/
                    Intent intent = new Intent(Level1.this, GameLevels.class);//Створення наміру перехода
                    startActivity(intent);//Старт наміру
                    finish();// Закрити цей клас
                    /*Вернутися назад до вибору рівня кінець*/
                }catch (Exception e){

                }
                /*Оброботка нажаття кнопки "Назад" кінець*/
            }
        });
        /*Кнопка "Назад" кінець*/

        /*Масив для прогресу гри початок*/
        final int[] progres = {
                R.id.point1 , R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };
        /*Масив для прогресу гри кінець*/

        /*Підключеня анімації початок*/
        final Animation a = AnimationUtils.loadAnimation(Level1.this, R.anim.alpha);
        /*Підключеня анімації кінець*/

        /* Створення виводу на екран цифр початок*/
        numLeft = random.nextInt(10);//Генеруєємо стлучайне число від 0 до 9
        img_left.setImageResource(array.images1[numLeft]);//Достаємо з масива картинку
        text_left.setText(array.texts1[numLeft]);//Достаємо з масива текст

        numRight = random.nextInt(10);//Генеруєємо стлучайне число від 0 до 9

        /*Цикл з передумовою перевіряючий рівність початок*/
        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }
        /*Цикл з передумовою перевіряючий рівність кінець*/
        img_right.setImageResource(array.images1[numRight]);//Достаємо з масива картинку
        text_right.setText(array.texts1[numRight]);//Достаємо з масива текст
        /* Створення виводу на екран цифр кінець*/
        /*Виклик діалогового вікна на початку гри кінець*/

        /*Оброботка нажаття на ліву картинку початок*/
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Умова дотику картинки початок
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //Якщо доторкнувся до картинки початок
                    img_right.setEnabled(false);//Блокуємо праву картинку
                    if (numLeft>numRight){
                        img_left.setImageResource(R.drawable.img_true);
                    }else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                    //Якщо доторкнувся до картинки кінець
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    //Якщо відпустив палець початок
                    if (numLeft>numRight){
                        //якщо ліва картинка більша
                        if (count<20){
                            count = count + 1;
                        }
                        /*Закрашуємо прогрес сірим кольором початок*/
                        for (int  i = 0; i<20; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        /*Закрашуємо прогрес сірим кольором кінець*/

                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором початок*/
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором кінець*/

                    }else {
                        //якщо ліва картинка меньша
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        /*Закрашуємо прогрес сірим кольором початок*/
                        for (int  i = 0; i<19; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        /*Закрашуємо прогрес сірим кольором кінець*/

                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором початок*/
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором кінець*/
                    }
                    //Якщо відпустив палець кінець
                    if (count==20){
                        dialogEnd.show();
                        //ВИХІД З РІВНЯ
                    }else {
                        numLeft = random.nextInt(10);//Генеруєємо стлучайне число від 0 до 9
                        img_left.setImageResource(array.images1[numLeft]);//Достаємо з масива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);//Достаємо з масива текст


                        numRight = random.nextInt(10);//Генеруєємо стлучайне число від 0 до 9

                        /*Цикл з передумовою перевіряючий рівність початок*/
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        /*Цикл з передумовою перевіряючий рівність кінець*/
                        img_right.setImageResource(array.images1[numRight]);//Достаємо з масива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts1[numRight]);//Достаємо з масива текст

                        img_right.setEnabled(true);//Включаємо обратно праву картинку
                    }
                }
                //Умова дотику картинки кінець
                return true;
            }
        });
        /*Оброботка нажаття на ліву картинку кінець*/

        /*Оброботка нажаття на праву картинку початок*/
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Умова дотику картинки початок
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //Якщо доторкнувся до картинки початок
                    img_left.setEnabled(false);//Блокуємо ліву картинку
                    if (numLeft<numRight){
                        img_right.setImageResource(R.drawable.img_true);
                    }else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                    //Якщо доторкнувся до картинки кінець
                }else if(event.getAction()==MotionEvent.ACTION_UP){
                    //Якщо відпустив палець початок
                    if (numLeft<numRight){
                        //якщо права картинка більша
                        if (count<20){
                            count = count + 1;
                        }
                        /*Закрашуємо прогрес сірим кольором початок*/
                        for (int  i = 0; i<20; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        /*Закрашуємо прогрес сірим кольором кінець*/

                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором початок*/
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором кінець*/

                    }else {
                        //якщо права картинка меньша
                        if (count>0){
                            if (count==1){
                                count=0;
                            }else {
                                count=count-2;
                            }
                        }
                        /*Закрашуємо прогрес сірим кольором початок*/
                        for (int  i = 0; i<19; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        /*Закрашуємо прогрес сірим кольором кінець*/

                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором початок*/
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progres[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        /*Опреділяємо правильні відповіді і замальовуємо зеленим кольором кінець*/
                    }
                    //Якщо відпустив палець кінець
                    if (count==20){
                        //ВИХІД З РІВНЯ
                        dialogEnd.show();
                    }else {
                        numLeft = random.nextInt(10);//Генеруєємо стлучайне число від 0 до 9
                        img_left.setImageResource(array.images1[numLeft]);//Достаємо з масива картинку
                        img_left.startAnimation(a);
                        text_left.setText(array.texts1[numLeft]);//Достаємо з масива текст


                        numRight = random.nextInt(10);//Генеруєємо стлучайне число від 0 до 9

                        /*Цикл з передумовою перевіряючий рівність початок*/
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        /*Цикл з передумовою перевіряючий рівність кінець*/
                        img_right.setImageResource(array.images1[numRight]);//Достаємо з масива картинку
                        img_right.startAnimation(a);
                        text_right.setText(array.texts1[numRight]);//Достаємо з масива текст

                        img_left.setEnabled(true);//Включаємо обратно ліву картинку
                    }
                }
                //Умова дотику картинки кінець
                return true;
            }
        });
        /*Оброботка нажаття на праву картинку кінець*/

    }
    /*Системна кнопка "Назад" початок*/
    @Override
    public void onBackPressed(){
        /*Оброботка нажаття кнопки "Назад" початок*/
        try {
            /*Вернутися назад до вибору рівня початок*/
            Intent intent = new Intent(Level1.this, GameLevels.class);//Створення наміру перехода
            startActivity(intent);//Старт наміру
            finish();// Закрити цей клас
            /*Вернутися назад до вибору рівня кінець*/
        }catch (Exception e){

        }
        /*Оброботка нажаття кнопки "Назад" кінець*/
    }
    /*Системна кнопка "Назад" кінець*/
}
