import React from 'react'

import {
    Link
} from "react-router-dom";

function Header() {
    return (
        <div>
            <header className="header">
                <div className="header__top">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-12">
                                <div className="header__top__inner">
                                    <div className="header__top__left">
                                        <ul>
                                            <li><Link to='/page/SignUp'>회원가입</Link></li>
                                            <li><Link to='/page/Login'>로그인</Link></li>
                                        </ul>
                                    </div>
                                    <div className="header__logo">
                                        <a href="../main/main.do"><img src="../img/mrlogo.png" alt="" style={{ width: '30%' }} /></a>
                                    </div>
                                    <div className="header__top__right">
                                        <div className="header__top__right__links">
                                            <a href="#" className="search-switch"><img src="../img/icon/search.png" alt="" /></a>
                                            <a href="#"><img src="../img/icon/heart.png" alt="" /></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="canvas__open"><i className="fa fa-bars"></i></div>
                    </div>
                </div>
                <div className="container">
                    <div className="row">
                        <div className="col-lg-12">
                            <nav className="header__menu mobile-menu">
                                <ul>
                                    <li><Link to='/page/MyRefriger'>MY냉장고</Link></li>
                                    <li><Link to='/page/recipe'>레시피</Link></li>
                                    <li><Link to='/page/restaurant'>맛집</Link></li>
                                    <li><Link to='/page/recommand'>추천</Link></li>
                                    <li><Link to='/page/community'>커뮤니티</Link>
                                        <ul className="dropdown">
                                            <li><a href="#">Shop Details</a></li>
                                            <li><a href="#">Shoping Cart</a></li>
                                            <li><a href="#">Check Out</a></li>
                                            <li><a href="#">Wisslist</a></li>
                                            <li><a href="#">Class</a></li>
                                            <li><a href="#">Blog Details</a></li>
                                        </ul>
                                    </li>
                                    <li><Link to='/page/contact'>Contact</Link></li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
            </header>
        </div>
    )
}

export default Header
