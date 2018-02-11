#include "mainwindow.h"
#include "ui_mainwindow.h"

MainWindow::MainWindow(QWidget *parent) : QMainWindow(parent) {
    centralWidget = new QWidget(this);
    this->setCentralWidget(centralWidget);
    grid = new QGridLayout(centralWidget);

    newGame = new QPushButton();
    newGame->setText("New Game");
    QObject::connect(newGame, SIGNAL(clicked()), this, SLOT(Init()));
    grid->addWidget(newGame, 0, 0);

    title = new QLabel("2048", this);
    title->setAlignment(Qt::AlignCenter);
    title->setStyleSheet("QLabel { color: black; font:30pt; font-weight:500; }");
    grid->addWidget(title, 0, 1);

    title2 = new QLabel("game", this);
    title2->setAlignment(Qt::AlignCenter);
    title2->setStyleSheet("QLabel { color: black; font:20pt; font-weight:300; }");
    grid->addWidget(title2, 0, 2);

    score = 0;
    scoreLabel = new QLabel("Score: \n 0", this);
    scoreLabel->setAlignment(Qt::AlignCenter);
    scoreLabel->setStyleSheet("QLabel { background-color: #bbae9e; color: white; font:15pt; font-weight:200; border-radius: 5px; }");
    grid->addWidget(scoreLabel, 0, 3);

    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j) {
            labels[i][j] = new QLabel("", this);
            grid->addWidget(labels[i][j], i+1, j);
            labels[i][j]->setAlignment(Qt::AlignCenter);
            changeColor(i, j);
        }
    labels[1][0]->setFocus();

    setWindowTitle("2048");
    setFixedSize(400, 400);
    Generate();
}

MainWindow::~MainWindow() {
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j)
            delete labels[i][j];
}

void MainWindow::Init() {
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j) {
            labels[i][j]->setText("");
            changeColor(i, j);
        }
    newGame->clearFocus();
    Generate();
}


void MainWindow::Generate() {
    bool hasPlace = false;
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j) {
            if (labels[i][j]->text() == "" || labels[i][j]->text() == "2") {
                hasPlace = true;
                break;
            }
        }
    if (!hasPlace) {
        QDialog* endDialog = new QDialog();
        endDialog->setMinimumWidth(200);
        endDialog->show();
    }
    int row = 0, column = 0;
    do {
        row = rand() % 4;
        column = rand() % 4;
    } while (labels[row][column]->text() != "" && labels[row][column]->text() != "2");
    labels[row][column]->setText(QString::number(labels[row][column]->text().toInt() + 2));
    changeColor(row,column);
}

void MainWindow::changeColor(int i, int j) {
    switch (labels[i][j]->text().toInt()) {
        case 0:
            labels[i][j]->setStyleSheet("QLabel { background-color: #cdc1b5; color: black; font:20pt; font-weight:400; border-radius: 5px;}");
            break;
        case 2:
            labels[i][j]->setStyleSheet("QLabel { background-color: #eee4da; color: black; font:20pt; font-weight:400; border-radius: 5px;}");
            break;
        case 4:
            labels[i][j]->setStyleSheet("QLabel { background-color: #eddfc4; color: black; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 8:
            labels[i][j]->setStyleSheet("QLabel { background-color: #f4b17a; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 16:
            labels[i][j]->setStyleSheet("QLabel { background-color: #f79663; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 32:
            labels[i][j]->setStyleSheet("QLabel { background-color: #f67d62; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 64:
            labels[i][j]->setStyleSheet("QLabel { background-color: #f65e39; color: white; font:20pt; font-weight:400; border-radius: 5px;}");
            break;
        case 128:
            labels[i][j]->setStyleSheet("QLabel { background-color: #edce73; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 256:
            labels[i][j]->setStyleSheet("QLabel { background-color: #e9cf58; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 512:
            labels[i][j]->setStyleSheet("QLabel { background-color: #edc651; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 1024:
            labels[i][j]->setStyleSheet("QLabel { background-color: #eec744; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
        case 2048:
            labels[i][j]->setStyleSheet("QLabel { background-color: #edca64; color: white; font:20pt; font-weight:400;border-radius: 5px;}");
            break;
    }
}

void MainWindow::keyPressEvent(QKeyEvent * event) {
    QString* a[4][4];
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j)
            a[i][j] = new QString(labels[i][j]->text());

    switch (event->key()) {
        case Qt::Key_Up:
            up();
            break;
        case Qt::Key_Down:
            down();
            break;
        case Qt::Key_Left:
            left();
            break;
        case Qt::Key_Right:
            right();
            break;
        default:
          QMainWindow::keyPressEvent(event);
    }

    bool flag = false;
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j)
            if (a[i][j] != labels[i][j]->text())
                flag = true;
    if (flag)
        Generate();
}

void MainWindow::down() {
    for (int j = 0; j < 4; ++j)
        for (int i = 3; i >= 0; --i)
            if (labels[i][j]->text() == "")
                for (int k = i-1; k >= 0; --k)
                    if (labels[k][j]->text() != "") {
                        labels[i][j]->setText(labels[k][j]->text());
                        changeColor(i,j);
                        labels[k][j]->setText("");
                        changeColor(k,j);
                        break;
                    }
    int k;
    for (int j = 0; j < 4; ++j) {
        for (int i = 2; i >= 0; i--) {
            if (labels[i][j]->text() == labels[i+1][j]->text() && labels[i][j]->text() != "") {
                    labels[i+1][j]->setText(QString::number(labels[i+1][j]->text().toInt() * 2));
                    score += labels[i+1][j]->text().toInt();
                    scoreLabel->setText("Score: \n" + QString::number(score));
                    changeColor(i+1, j);

                    k = i;
                    while (k > 0) {
                        k--;
                        labels[k+1][j]->setText(labels[k][j]->text());
                        changeColor(k+1, j);
                    }
                    if (k == 0) {
                        labels[0][j]->setText("");
                        changeColor(0, j);
                    }
            }
        }
    }
}

void MainWindow::up() {
    rotate();
    rotate();
    down();
    rotate();
    rotate();
}

void MainWindow::left() {
    rotate();
    down();
    rotate();
    rotate();
    rotate();
}

void MainWindow::right() {
    rotate();
    rotate();
    rotate();
    down();
    rotate();
}

void MainWindow::rotate() {
    int a[4][4];
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j) {
            a[4-j-1][i] = labels[i][j]->text().toInt();
        }
    for (int i = 0; i < 4; ++i)
        for (int j = 0; j < 4; ++j) {
            if (a[i][j] == 0) {
                labels[i][j]->setText("");
            } else {
                labels[i][j]->setText(QString::number(a[i][j]));
            }
            changeColor(i, j);
        }
}
