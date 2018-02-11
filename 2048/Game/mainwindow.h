#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QLabel>
#include <QGridLayout>
#include <QKeyEvent>
#include <QDialog>
#include <QPushButton>

namespace Ui {
class MainWindow;
}

class MainWindow : public QMainWindow
{
    Q_OBJECT

public:
    explicit MainWindow(QWidget *parent = 0);
    ~MainWindow();

protected:
    virtual void keyPressEvent(QKeyEvent * event);

private slots:
    void Init();

private:
    void Generate();
    void up();
    void down();
    void left();
    void right();
    void rotate();
    void changeColor(int x, int y);

    int score;

    QWidget *centralWidget;
    QPushButton *newGame;
    QLabel *title, *title2;
    QLabel *scoreLabel;
    QGridLayout *grid;
    QLabel* labels[4][4];
};

#endif // MAINWINDOW_H
