import React, { useState, memo } from 'react';
import { DropBox } from './DropBox';
import { Box } from './Box';

export const Container = memo(function Container() {

    // 백엔드에서 데이터를 받아와서 material에 재료 저장
    const [material, setMaterial] = useState([]);

    // 백엔드에서 데이터를 받아와서 material에 레시피 저장
    const [recipe, setRecipe] = useState([]);

    return (
        <div style={{ display: 'flex', flexDirection: 'row', width: '100%', background: '#c5ccd6' }}>
            <div>
                <DropBox />
            </div>
            <div>
                <div>

                </div>
                <div style={{ display: 'flex', justifyContent: 'center', marginTop: '2rem' }}>
                    <select>
                        <option>분류1</option>
                        <option>분류2</option>
                        <option>분류3</option>
                    </select>
                    <select>
                        <option>재료1</option>
                        <option>재료2</option>
                        <option>재료3</option>
                    </select>
                    <input type="text" />
                    <button>검색</button>
                </div>
                <div style={{ margin: '3rem' }}>
                    <Box name="밑반찬" />
                    <Box name="메인반찬" />
                    <Box name="국 / 탕" />
                    <Box name="찌개" />
                    <Box name="디저트" />
                    <Box name="면 / 만두" />
                    <Box name="밥 / 죽 / 떡" />
                    <Box name="퓨전" />
                    <Box name="김치 / 젓갈 / 장류" />
                    <Box name="양념 / 소스 / 잼" />
                    <Box name="양식" />
                    <Box name="샐러드" />
                    <Box name="스프" />
                    <Box name="빵" />
                    <Box name="과자" />
                    <Box name="차 / 음료 / 술" />
                    <Box name="기타" />
                </div>
            </div>
        </div>
    );
});
